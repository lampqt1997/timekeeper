package com.isc.timekeeper.multipledb.timekeeper.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class AccountDTO {
	
	private String username;
	private String password;
	

}
