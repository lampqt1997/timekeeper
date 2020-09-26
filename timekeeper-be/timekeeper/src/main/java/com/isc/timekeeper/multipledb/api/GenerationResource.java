package com.isc.timekeeper.multipledb.api;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isc.timekeeper.multipledb.biostar.entity.BioStarDepartment;
import com.isc.timekeeper.multipledb.biostar.entity.BioStarEvenLog;
import com.isc.timekeeper.multipledb.biostar.entity.BioStarUser;
import com.isc.timekeeper.multipledb.biostar.service.BioStarDepartmentService;
import com.isc.timekeeper.multipledb.biostar.service.BioStarEvenLogBKService;
import com.isc.timekeeper.multipledb.biostar.service.BioStarEvenLogService;
import com.isc.timekeeper.multipledb.biostar.service.BioStarUserService;
import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperDepartment;
import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperEmployee;
import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperEvenLog;
import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperPosition;
import com.isc.timekeeper.multipledb.timekeeper.service.TimeKeeperDepartmentService;
import com.isc.timekeeper.multipledb.timekeeper.service.TimeKeeperEmployeeService;
import com.isc.timekeeper.multipledb.timekeeper.service.TimeKeeperEvenLogService;
@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/data")
public class GenerationResource {

	// EvenLog
	@Autowired
	private BioStarEvenLogService bEvenLogService;
	@Autowired
	private BioStarEvenLogBKService bEvenLogBKService;
	@Autowired
	private TimeKeeperEvenLogService tkEvenLogService;
	// Employee and User
	@Autowired
	private TimeKeeperEmployeeService tkEmployeeService;
	@Autowired
	private BioStarUserService bUserService;
	// Department
	@Autowired
	private TimeKeeperDepartmentService tkDepartmentService;
	@Autowired
	private BioStarDepartmentService bDepartmentService;

	@GetMapping(path = "/copy/evenlog")
	public String copyEvenLogFromBioStarToTimeKeeper() throws Exception {
		Integer idEvenTimeKeeper = 0;
		List<TimeKeeperEvenLog> evenLogs = null;
		idEvenTimeKeeper = tkEvenLogService.getCurrent() == null ? 0 : tkEvenLogService.getCurrent();
//		List<Object[]> userEvenLogs = bEvenLogService.getAllCustomFromIdToMax(idEvenTimeKeeper);
//		List<Object[]> userEvenLogBKs = bEvenLogBKService.getAllCustomFromIdToMax(idEvenTimeKeeper);
		List<Object[]> userEvenLogs = bEvenLogService.getAllCustom();
		List<Object[]> userEvenLogBKs = bEvenLogBKService.getAllCustom();
		evenLogs = new ArrayList<>();
		for (Object[] objects : userEvenLogs) {
			Optional<TimeKeeperEmployee> te = tkEmployeeService.getByCode(objects[1].toString());
			if (te != null) {
				evenLogs.add(TimeKeeperEvenLog.builder().evenLogId((Integer) objects[0])
						.checkDate( ((Timestamp) objects[2]).toLocalDateTime()).isDisable(false).timeCreated(LocalDateTime.now())
						.employee(te.get()).build());
			} else {

				continue;
			}

		}
		for (Object[] objects2 : userEvenLogBKs) {
			Optional<TimeKeeperEmployee> te = tkEmployeeService.getByCode(objects2[1].toString());
			if (te != null) {
				evenLogs.add(TimeKeeperEvenLog.builder().evenLogId((Integer) objects2[0])
						.checkDate( ((Timestamp) objects2[2]).toLocalDateTime()).isDisable(false).timeCreated(LocalDateTime.now())
						.employee(te.get()).build());
			} else {

				continue;
			}

		}
		System.out.println(evenLogs);
		tkEvenLogService.saveAll(evenLogs);
		return evenLogs.toString();
	}


	@GetMapping(path = "/copy/employee")
	public String copyEmployeeFromBioStarToTimeKeeper() {
		Integer idEmployeeMax = 0;
		List<TimeKeeperEmployee> employees = null;
		try {
			idEmployeeMax = tkEmployeeService.getMax() == null ? 0 : tkEmployeeService.getMax();
			if (idEmployeeMax != null) {
				List<Object[]> users = bUserService.getFromIdToMax(idEmployeeMax);
			
				employees = new ArrayList<>();
				for (Object[] objs : users) {
					employees.add(TimeKeeperEmployee.builder()
							.employeeId((Integer) objs[0])
							.employeeCode(objs[1].toString())
							.firstName(objs[2].toString().substring(0,objs[2].toString().lastIndexOf(" ") ))
							.lastName(objs[2].toString().substring(objs[2].toString().lastIndexOf(" "),objs[2].toString().length() ))
							.startDate(((Timestamp) objs[3]).toLocalDateTime().toLocalDate())
							.endDate(((Timestamp) objs[4]).toLocalDateTime().toLocalDate())
							.address("")
							.phoneNumber(objs[5].toString())
							.isDisable(false)
							.position(TimeKeeperPosition.builder().positionId(1).pName("Công nhân").build())
							.department(tkDepartmentService.get((Integer) objs[6]).get()).build());
					tkEmployeeService.saveAll(employees);
				}
			}
		} catch (NullPointerException e) {
//			System.out.println(e.getMessage());
//			idEmployeeMax = 0;
//			List<BioStarUser> bList = bUserService.getFromIdToMax(idEmployeeMax);
//			employees = new ArrayList<>();
//			for (BioStarUser bu : bList) {
//				employees.add(TimeKeeperEmployee.builder().employeeId(bu.getNUserIdn()).firstName("").lastName("")
//						.startDate(new Date(bu.getNStartDate()).toLocalDate())
//						.endDate(new Date(bu.getNEndDate()).toLocalDate()).address("").phoneNumber("0987654231").isDisable(false)
//						.position(TimeKeeperPosition.builder().positionId(1).pName("Công nhân").build())
//						.department(TimeKeeperDepartment.builder().departmentId(1).dName("").build()).build());
//				tkEmployeeService.saveAll(employees);
//			}
		}

		return employees.toString();
	}

	@GetMapping(path = "/copy/department")
	public String copyDepartmentFromBioStarToTimeKeeper() {
		Integer idDepartment = 0;
		List<TimeKeeperDepartment> tList = null;
		try {
			idDepartment = tkDepartmentService.getMax() == null ? 0 : tkDepartmentService.getMax();
			if (idDepartment != null) {
				System.out.println("not null");
				List<BioStarDepartment> bList = bDepartmentService.getFromIdToMax(idDepartment);
				tList = new ArrayList<>();
				for (BioStarDepartment tkd : bList) {
					tList.add(TimeKeeperDepartment.builder().departmentId(tkd.getNDepartmentIdn()).dName(tkd.getSName())
							.isDisable(false).build());
				}
				tkDepartmentService.saveAll(tList);
			}
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			System.out.println("null");
			idDepartment = 0;
			List<BioStarDepartment> bList = bDepartmentService.getFromIdToMax(idDepartment);
			tList = new ArrayList<>();
			for (BioStarDepartment tkd : bList) {
				tList.add(TimeKeeperDepartment.builder().departmentId(tkd.getNDepartmentIdn()).dName(tkd.getSName())
						.isDisable(false).build());
			}
			tkDepartmentService.saveAll(tList);
		}

		return tList.toString();
	}
}
