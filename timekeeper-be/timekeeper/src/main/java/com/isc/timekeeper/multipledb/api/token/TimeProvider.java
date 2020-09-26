package com.isc.timekeeper.multipledb.api.token;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class TimeProvider implements Serializable {
	
	public Date now() {
		return new Date();
	}
}
