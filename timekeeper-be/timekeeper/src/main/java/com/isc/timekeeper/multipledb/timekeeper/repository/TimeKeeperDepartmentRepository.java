package com.isc.timekeeper.multipledb.timekeeper.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperDepartment;

@Repository
public interface TimeKeeperDepartmentRepository extends JpaRepository<TimeKeeperDepartment, Integer> {

	
	@Query(value="select max(biostartDepartmentId) from TimeKeeperDepartment ")
	public Integer getMax();
	
	public Optional<TimeKeeperDepartment> findByBiostartDepartmentId(Integer id);

}
