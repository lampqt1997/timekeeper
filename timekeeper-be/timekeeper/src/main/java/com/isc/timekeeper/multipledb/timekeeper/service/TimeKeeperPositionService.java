package com.isc.timekeeper.multipledb.timekeeper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperPosition;
import com.isc.timekeeper.multipledb.timekeeper.repository.TimeKeeperPositionRepository;

@Service
public class TimeKeeperPositionService {
	
	@Autowired
	private TimeKeeperPositionRepository tkPositionRepository;
	
	public TimeKeeperPosition addPosition(TimeKeeperPosition tk) {
		return tkPositionRepository.saveAndFlush(tk);
	}
}
