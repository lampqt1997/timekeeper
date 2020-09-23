package com.isc.timekeeper.multipledb.timekeeper.dto;

import java.time.LocalDate;

import javax.annotation.Generated;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class TimeKeeperSpecialDayDTO {

	private String title;
	private LocalDate date;
}
