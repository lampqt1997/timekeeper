package com.isc.timekeeper.multipledb.timekeeper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperSpecialDay;
@Repository
public interface TimeKeeperSpecialDayRepository extends JpaRepository<TimeKeeperSpecialDay, Integer> {
	@Query(value="select max(spId) from TimeKeeperSpecialDay")
	public Integer getMaxId();
}
