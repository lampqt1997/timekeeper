package com.isc.timekeeper.multipledb.timekeeper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperUser;

@Repository
public interface TimeKeeperUserRepository extends JpaRepository<TimeKeeperUser, Integer> {

	@Query(value="select max(userId) from TimeKeeperUser ")
	public Integer getMaxId();
}
