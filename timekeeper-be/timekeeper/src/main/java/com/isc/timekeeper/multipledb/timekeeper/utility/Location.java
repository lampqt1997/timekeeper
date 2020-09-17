package com.isc.timekeeper.multipledb.timekeeper.utility;

public enum Location {
	HOCHIMINH("Hồ Chí Minh"), DANANG("Đà Nẵng"), CANTHO("Cần Thơ"), HUE("Huế"), HANOI("Hà Nội");
	private String Description;
	
	Location(String desc){
		
	}
	public String getValue() {
		return name();
	}
	
	public String getDescription() {
		return Description;
	}
}
