package com.isc.timekeeper.multipledb.timekeeper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperShift;
import com.isc.timekeeper.multipledb.timekeeper.repository.TimeKeeperShiftRepository;

@Service
public class TimeKeeperShiftService {
	
	@Autowired
	TimeKeeperShiftRepository tkShiftRepository;
	
	public TimeKeeperShift addShift(TimeKeeperShift shift) {
		return tkShiftRepository.saveAndFlush(shift);
	}
}
