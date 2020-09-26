package com.isc.timekeeper.multipledb.api.token;

import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperUser;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class TokenCustom {

	private String token;
	private TimeKeeperUser user;

	
}
