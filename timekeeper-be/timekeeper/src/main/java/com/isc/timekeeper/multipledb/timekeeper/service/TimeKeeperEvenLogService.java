package com.isc.timekeeper.multipledb.timekeeper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperEvenLog;
import com.isc.timekeeper.multipledb.timekeeper.repository.TimeKeeperEvenLogRepository;

@Service
public class TimeKeeperEvenLogService {

	@Autowired
	private TimeKeeperEvenLogRepository evenLogRepository;
	
	public List<TimeKeeperEvenLog> getAll(){
		return evenLogRepository.findAll(); 
	}
	
	public Integer getCurrent() {
		return evenLogRepository.getMaxId();
	}
	
	public void saveAll(List<TimeKeeperEvenLog> list) {
		evenLogRepository.saveAll(list);
	}
	
	
}
