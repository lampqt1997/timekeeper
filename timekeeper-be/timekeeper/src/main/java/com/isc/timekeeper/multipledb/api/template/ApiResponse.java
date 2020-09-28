package com.isc.timekeeper.multipledb.api.template;

import lombok.Setter;
import lombok.ToString;
import lombok.Builder;
import lombok.Getter;

@Builder
@Setter
@Getter
@ToString
public class ApiResponse {
	
	private Integer errorCode;
	private Object data;

}
