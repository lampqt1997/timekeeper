package com.isc.timekeeper.multipledb.api.token;

import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class UserTokenState {
	private String access_token;
	private Long expires_in;

//	
}
