package com.isc.timekeeper.multipledb.timekeeper.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperEmployee;

@Repository
public interface TimeKeeperEmployeeRepository extends JpaRepository<TimeKeeperEmployee, Integer> {

	

	@Query(value="select max(biostartEmployeeId) from TimeKeeperEmployee ")
	public Integer getMax();
	
	@Query(value="SELECT DISTINCT e FROM TimeKeeperEmployee e INNER JOIN FETCH e.department INNER JOIN FETCH e.position where e.employeeCode = :code")
	public Optional<TimeKeeperEmployee> findByCode(String code);
}
