package com.isc.timekeeper.multipledb.timekeeper.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeHelper {
	
	public static boolean isTheSameDayAndMonth(LocalDateTime value) {
		LocalDateTime now = LocalDateTime.now();
		return (now.getMonthValue()==value.getMonthValue()) && (now.getDayOfMonth() == value.getDayOfMonth());
	}
	
	public static int retiredYear(LocalDateTime value) {
		return (value.plusYears(60)).getYear();
	}
	
	public static int restYearToRetireYear(LocalDateTime value) {
		return (value.plusYears(60).getYear() - LocalDateTime.now().getYear());
	}
	
	public static int getAge(LocalDateTime value) {
		LocalDateTime now = LocalDateTime.now();
		if (now.getDayOfMonth() > value.getDayOfMonth() && now.getMonthValue() >= value.getMonthValue()) {
			return  (now.getYear() - value.getYear());
		}
		return (now.getYear() - value.getYear())-1;
	}
	
	public static String vnFormatDate(LocalDateTime value) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return value.format(formatter);
	}
	
	public static String hourAndSecond(LocalDateTime value) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:ss");
		return value.format(formatter);
	}
	
	public static void main(String[] args) {
		System.out.println(hourAndSecond(LocalDateTime.now()));
	}
	
}
