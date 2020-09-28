package com.isc.timekeeper.multipledb.biostar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isc.timekeeper.multipledb.biostar.entity.BioStarUser;

@Repository
public interface BioStarUserRepository extends JpaRepository<BioStarUser, Integer> {
	@Query(value = "select max(nUserIdn) from BioStarUser ")
	public Integer getMaxId();

	@Query(value = "from BioStarUser where nUserIdn between :id and (select max(nUserIdn) from BioStarUser)")
	public List<BioStarUser> getFromIdToMax(Integer id);

}
