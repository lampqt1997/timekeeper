package com.isc.timekeeper.multipledb.timekeeper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperUpdateLog;

public interface TimeKeeperUpdateLogRepository extends JpaRepository<TimeKeeperUpdateLog, Integer> {
	@Query(value="select max(updateLogId) from TimeKeeperUpdateLog ")
	public Integer getMaxId();
}
