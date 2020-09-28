package com.isc.timekeeper.multipledb.api;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isc.timekeeper.multipledb.api.template.ApiResponse;
import com.isc.timekeeper.multipledb.api.template.PaginationResponse;
import com.isc.timekeeper.multipledb.api.token.JwtTokenUtil;
import com.isc.timekeeper.multipledb.timekeeper.dto.TimeKeeperDTO;
import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperEmployee;
import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperEmployeeShift;
import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperEvenLog;
import com.isc.timekeeper.multipledb.timekeeper.service.TimeKeeperEmployeeService;
import com.isc.timekeeper.multipledb.timekeeper.service.TimeKeeperEmployeeShiftService;
import com.isc.timekeeper.multipledb.timekeeper.service.TimeKeeperEvenLogService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/timekeeper")
public class TimeKeeperResource {
	@Autowired
	private JwtTokenUtil tokenHelper;

	@Autowired
	private TimeKeeperEmployeeService tkEmployeeService;

	@Autowired
	private TimeKeeperEvenLogService tkEvenLogService;

	@Autowired
	private TimeKeeperEmployeeShiftService tkEmployeeShiftService;

	@GetMapping(path = "/current/{page}/{numberOfResult}")
	public ResponseEntity<?> getTimeKeepeAtCurrentDay(HttpServletRequest request, HttpServletResponse response,
			@PathVariable int page, @PathVariable int numberOfResult) {
		String authToken = tokenHelper.getToken(request);
		String userName = tokenHelper.getUsernameFromToken(authToken);

		if (tokenHelper.validateToken(authToken, userName)) {
			int count = tkEvenLogService.countRecordCurrent();
			int total = (count / numberOfResult);
			List<TimeKeeperEvenLog> listEvents = tkEvenLogService.getTimeKeepeAtCurrentDay(page, numberOfResult);
			List<TimeKeeperDTO> tkDTOs = createResultByEventLog(listEvents,LocalDate.now());
			return new ResponseEntity<Object>(ApiResponse
					.builder().errorCode(0).data(PaginationResponse.builder().currentPage(page).totalPage(total)
							.totalResult(numberOfResult).data(tkDTOs.isEmpty() ? "No result" : tkDTOs).build())
					.build(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(ApiResponse.builder().errorCode(1).data("token valid").build(),
					HttpStatus.OK);
		}

	}

	
	@GetMapping(path = "/{page}/{numberOfResult}/{date}")
	public ResponseEntity<?> getTimeKeepeByDate(
			HttpServletRequest request, HttpServletResponse response, 
			@PathVariable int page,
			@PathVariable int numberOfResult,
			@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		System.out.println(date);
		String authToken = tokenHelper.getToken(request);
		String userName = tokenHelper.getUsernameFromToken(authToken);
		System.out.println(userName);
		if (tokenHelper.validateToken(authToken, userName)) {
			int count = tkEvenLogService.countRecordByDate(date);
			int total = (count / numberOfResult);
			List<TimeKeeperEvenLog> listEvents = tkEvenLogService.getTimeKeeper(page, numberOfResult, date);
			List<TimeKeeperDTO> tkDTOs = createResultByEventLog(listEvents,date);

			return new ResponseEntity<Object>(ApiResponse
					.builder().errorCode(0).data(PaginationResponse.builder().currentPage(page).totalPage(total)
							.totalResult(numberOfResult).data(tkDTOs.isEmpty() ? "No result" : tkDTOs).build())
					.build(), HttpStatus.OK);
		} else {
			ApiResponse apiMessage = ApiResponse.builder().errorCode(1).data("token valid").build();
			return new ResponseEntity<Object>(apiMessage, HttpStatus.OK);
		}

	}
	private List<TimeKeeperDTO> createResultByEventLog(List<TimeKeeperEvenLog> listEvents,LocalDate date) {
		List<TimeKeeperDTO> dtos = new ArrayList<TimeKeeperDTO>();
		List<String> times = new ArrayList<String>();		
		String idBefore = "0", idAfter = "0";
		TimeKeeperDTO dto = null;
		for (TimeKeeperEvenLog timeKeeperEvenLog : listEvents) {
			idAfter = timeKeeperEvenLog.getEmployee().getEmployeeCode();
			TimeKeeperEmployee user = timeKeeperEvenLog.getEmployee();
			TimeKeeperEmployeeShift emShift = tkEmployeeShiftService.getShiftByDateAndEmployeeCode(date,user.getEmployeeCode());
			if (idBefore.equals(idAfter)) {
				times.add(timeKeeperEvenLog.getECheckDate().format(DateTimeFormatter.ofPattern("HH:mm")));
				dto.setTime(times);
			} else {
				if (dto==null) {
					dto = TimeKeeperDTO.builder()
							.employeeId(user.getEmployeeId())
							.employeeCode(user.getEmployeeCode())
							.fullName(user.getFirstName() + " " + user.getLastName())
							.department(user.getDepartment().getDepartmentName())
							.position(user.getPosition().getPName())
							.shift(emShift.getShift().getShiftName())
							.time(times)
							.build();
				}else {
					dtos.add(dto);
					times = new ArrayList<String>();
					dto = TimeKeeperDTO.builder()
							.employeeId(user.getEmployeeId())
							.employeeCode(user.getEmployeeCode())
							.fullName(user.getFirstName() + " " + user.getLastName())
							.department(user.getDepartment().getDepartmentName())
							.position(user.getPosition().getPName())
							.shift(emShift.getShift().getShiftName())
							.time(times)
							.build();
					times.add(timeKeeperEvenLog.getECheckDate().format(DateTimeFormatter.ofPattern("HH:mm")));	
				}
				
				
			}
			
			idBefore = idAfter;
		}

		return dtos;

	}

}
