package com.isc.timekeeper.multipledb.timekeeper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperPosition;
@Repository
public interface TimeKeeperPositionRepository extends JpaRepository<TimeKeeperPosition, Integer> {
	@Query(value="select max(positionId) from TimeKeeperPosition ")
	public Integer getMaxId();
	
	
}
