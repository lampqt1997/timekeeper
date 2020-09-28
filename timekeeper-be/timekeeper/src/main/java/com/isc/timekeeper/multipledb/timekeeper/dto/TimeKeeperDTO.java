package com.isc.timekeeper.multipledb.timekeeper.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class TimeKeeperDTO {

	private Integer employeeId;
	private String employeeCode;
	private String fullName;
	private String department;
	private String position;
	private String shift;
	private List<String> time;
	
	
	
}
