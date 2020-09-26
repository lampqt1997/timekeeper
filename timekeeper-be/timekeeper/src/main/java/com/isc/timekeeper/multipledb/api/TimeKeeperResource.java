package com.isc.timekeeper.multipledb.api;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isc.timekeeper.multipledb.api.template.ApiResponse;
import com.isc.timekeeper.multipledb.api.template.PaginationResponse;
import com.isc.timekeeper.multipledb.api.token.JwtTokenUtil;
import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperEvenLog;
import com.isc.timekeeper.multipledb.timekeeper.service.TimeKeeperEmployeeService;
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
	
	@GetMapping(path="/current/{page}/{numberOfResult}")
	public ResponseEntity<?> getTimeKeepeAtCurrentDay(HttpServletRequest request, HttpServletResponse response, @PathVariable int page, @PathVariable int numberOfResult){
		String authToken = tokenHelper.getToken(request);
//		Device device = DeviceUtils.getCurrentDevice(request);
		String userName = tokenHelper.getUsernameFromToken(authToken);
		
		if (tokenHelper.validateToken(authToken, userName)) {
			int count = tkEvenLogService.countRecordCurrent();
			System.out.println(count);
			int total =  (count / numberOfResult);
			List<TimeKeeperEvenLog> listEvents = tkEvenLogService.getTimeKeepeAtCurrentDay(page,numberOfResult);
//			for
			
			
			
			
			ApiResponse apiResponse = ApiResponse.builder()
					.errorCode(0)
					.data(PaginationResponse.builder()
							.currentPage(page)
							.totalPage(total)
							.totalResult(numberOfResult)
							.data(listEvents.isEmpty()?"No result":listEvents)
							.build())
					.build(); 
			return new ResponseEntity<Object>(apiResponse,HttpStatus.OK);
		}else {
			ApiResponse apiMessage = ApiResponse.builder()
					.errorCode(1)
					.data("token valid")
					.build(); 
			return new ResponseEntity<Object>(apiMessage, HttpStatus.OK);
		}
	
		
	}
	@GetMapping(path="/{page}/{numberOfResult}/{date}")
	public ResponseEntity<?> getTimeKeepeByDate(HttpServletRequest request, HttpServletResponse response, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @PathVariable int page, @PathVariable int numberOfResult){
		String authToken = tokenHelper.getToken(request);
//		Device device = DeviceUtils.getCurrentDevice(request);
		String userName = tokenHelper.getUsernameFromToken(authToken);
		if (authToken != null && userName != null) {
			int count = tkEvenLogService.countRecordByDate(date);
			System.out.println(count);
			int total = (count / numberOfResult);
			List<TimeKeeperEvenLog> listEvents = tkEvenLogService.getTimeKeeper(page, numberOfResult, date);
			ApiResponse apiResponse = ApiResponse.builder()
					.errorCode(0)
					.data(PaginationResponse.builder()
							.currentPage(page)
							.totalPage(total)
							.totalResult(numberOfResult)
							.data(listEvents)
							.build())
					.build(); 
			return new ResponseEntity<Object>(apiResponse,HttpStatus.OK);
		}else {
			ApiResponse apiMessage = ApiResponse.builder()
					.errorCode(1)
					.data("token valid")
					.build(); 
			return new ResponseEntity<Object>(apiMessage, HttpStatus.OK);
		}
	
		
	}
}
