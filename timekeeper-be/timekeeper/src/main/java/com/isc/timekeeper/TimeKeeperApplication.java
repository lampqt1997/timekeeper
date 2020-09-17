package com.isc.timekeeper;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.isc.timekeeper.multipledb.biostar.entity.BioStarDepartment;
import com.isc.timekeeper.multipledb.biostar.entity.BioStarEvenLog;
import com.isc.timekeeper.multipledb.biostar.entity.BioStarEvenLogBK;
import com.isc.timekeeper.multipledb.biostar.entity.BioStarUser;
import com.isc.timekeeper.multipledb.biostar.service.BioStarDepartmentService;
import com.isc.timekeeper.multipledb.biostar.service.BioStarEvenLogBKService;
import com.isc.timekeeper.multipledb.biostar.service.BioStarEvenLogService;
import com.isc.timekeeper.multipledb.biostar.service.BioStarUserService;
import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperEmployee;
import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperPosition;
import com.isc.timekeeper.multipledb.timekeeper.service.TimeKeeperEmployeeService;
import com.isc.timekeeper.multipledb.timekeeper.service.TimeKeeperEvenLogService;
import com.isc.timekeeper.multipledb.timekeeper.service.TimeKeeperPositionService;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = { DataSourceTransactionManagerAutoConfiguration.class,
//		HibernateJpaAutoConfiguration.class })

public class TimeKeeperApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BioStarUserService seftService;
	@Autowired
	private BioStarEvenLogService bEvenLogService;
	@Autowired
	private BioStarEvenLogBKService bEvenLogBKService;
	
	@Autowired
	private TimeKeeperEvenLogService tkEvenLogService;
	
	@Autowired
	private BioStarDepartmentService bDepartmentService;
	@Autowired
	private TimeKeeperEmployeeService tkEmployeeService;
	@Autowired
	private TimeKeeperPositionService tkPositionService;
	
	public static void main(String[] args) {
		SpringApplication.run(TimeKeeperApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		TimeKeeperPosition po1 = new TimeKeeperPosition( "Công nhân", false);
		TimeKeeperPosition po2= new TimeKeeperPosition( "Kế toán", false);
		
		
		tkPositionService.addPosition(po1);
		tkPositionService.addPosition(po2);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		List<UserDept> uds = deptService.getAll();
//		List<UserSeft> uss = seftService.getAll();
//		List<UserEvenLog> uels = evenLogService.getAll();
//		List<UserEvenLogBK> uelbks = evenLogBKService.getAll();
//		System.out.println(uds);
//		System.out.println(uss);
//		System.out.println(uels);
//		System.out.println(uelbks);
//		System.out.println(evenLogService.getFromIdToMax(949600));
//		List<BioStarEvenLog> bList = bEvenLogService.getFromIdToMax(0);
//		for (BioStarEvenLog bioStarUser : bList) {
//			Optional<TimeKeeperEmployee> t = tkEmployeeService.getById(bioStarUser.getNUserID());
//			if (t.isPresent()) {
//				System.out.println(t.get());	
//			}
//		}
//		List<Object[]> os = bEvenLogService.getAllCustomFromIdToMax(0);
//		for (Object[] v : os) {
//			System.out.println(v[0]);
////			for (Object objects : v) {
////				System.out.println(objects);
////			}
//		}
	}

}
