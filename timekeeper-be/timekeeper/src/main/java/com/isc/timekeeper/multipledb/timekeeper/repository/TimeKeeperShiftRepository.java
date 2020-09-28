package com.isc.timekeeper.multipledb.timekeeper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperShift;

@Repository
public interface TimeKeeperShiftRepository extends JpaRepository<TimeKeeperShift, Integer> {
	@Query(value="select max(shiftId) from TimeKeeperShift ")
	public Integer getMaxId();
}
