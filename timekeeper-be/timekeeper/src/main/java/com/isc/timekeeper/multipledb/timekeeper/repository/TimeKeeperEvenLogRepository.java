package com.isc.timekeeper.multipledb.timekeeper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperEvenLog;

@Repository
public interface TimeKeeperEvenLogRepository extends JpaRepository<TimeKeeperEvenLog, Integer> {
	
	@Query(value="select max(biostartEvenLogId) from TimeKeeperEvenLog  ")
	public Integer getMaxId();
	
	
}
