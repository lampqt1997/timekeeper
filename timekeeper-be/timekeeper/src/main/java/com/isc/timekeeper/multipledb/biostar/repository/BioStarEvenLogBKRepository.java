package com.isc.timekeeper.multipledb.biostar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isc.timekeeper.multipledb.biostar.entity.BioStarEvenLogBK;

@Repository
public interface BioStarEvenLogBKRepository extends JpaRepository<BioStarEvenLogBK, Integer> {

	@Query(value = "select max(nEventLogIdn) from BioStarEvenLogBK ")
	public Integer getMaxId();

//	@Query(value="select max(ue.nEventLogIdn) from UserEvenLog ue ")

	@Query(value = "from BioStarEvenLogBK where nEventLogIdn between :id and (select max(nEventLogIdn) from BioStarEvenLogBK)")
	public List<BioStarEvenLogBK> getFromIdToMax(int id);
}
