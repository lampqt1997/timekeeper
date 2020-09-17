package com.isc.timekeeper.multipledb.timekeeper.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperEmployee;
import com.isc.timekeeper.multipledb.timekeeper.repository.TimeKeeperEmployeeRepository;

@Service
public class TimeKeeperEmployeeService {

	@Autowired
	private TimeKeeperEmployeeRepository employeeRepository;

	public Optional<TimeKeeperEmployee> getByCode(String id) {
		return employeeRepository.findByCode(id).isPresent() ? employeeRepository.findByCode(id) : null;
	}

	public Integer getMax() {
		return employeeRepository.getMax();

	}

	public void saveAll(List<TimeKeeperEmployee> employees) {
		employeeRepository.saveAll(employees);
		employeeRepository.flush();
	}
}
