package com.isc.timekeeper.multipledb.timekeeper.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperDepartment;
import com.isc.timekeeper.multipledb.timekeeper.repository.TimeKeeperDepartmentRepository;

@Service
public class TimeKeeperDepartmentService {

	@Autowired
	private TimeKeeperDepartmentRepository tkDepartmentRepository;
	
	public Integer getMax() {
	
		return tkDepartmentRepository.getMax();
	}

	public void saveAll(List<TimeKeeperDepartment> tList) {
		tkDepartmentRepository.saveAll(tList);
		tkDepartmentRepository.flush();
	}
	
	public Optional<TimeKeeperDepartment> get(Integer id) {
		return tkDepartmentRepository.findById(id);
	}

}
