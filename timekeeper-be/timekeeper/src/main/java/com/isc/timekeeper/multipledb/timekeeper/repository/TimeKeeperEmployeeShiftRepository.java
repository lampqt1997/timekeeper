package com.isc.timekeeper.multipledb.timekeeper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperEmployeeShift;

@Repository
public interface TimeKeeperEmployeeShiftRepository extends JpaRepository<TimeKeeperEmployeeShift, Integer> {
	@Query(value="select max(employeeShiftId) from TimeKeeperEmployeeShift ")
	public Integer getMax();
}
