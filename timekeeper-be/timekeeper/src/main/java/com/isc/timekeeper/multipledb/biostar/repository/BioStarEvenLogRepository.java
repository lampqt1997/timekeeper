package com.isc.timekeeper.multipledb.biostar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isc.timekeeper.multipledb.biostar.entity.BioStarEvenLog;

@Repository
public interface BioStarEvenLogRepository extends JpaRepository<BioStarEvenLog, Integer> {

	@Query(value = "select max(nEventLogIdn) from BioStarEvenLog  ")
	public Integer getMaxId();

//	@Query(value="select max(ue.nEventLogIdn) from UserEvenLog ue ")

	@Query(value = "from BioStarEvenLog where nEventLogIdn between :id and (select max(nEventLogIdn) from BioStarEvenLog)")
	public List<BioStarEvenLog> getFromIdToMax(int id);

	@Query(value = "select e.nEventLogIdn, dateadd(s,ndatetime,'1970-01-01 00:00:00') from TB_EVENT_LOG e between :id and (select max(nEventLogIdn) from TB_EVENT_LOG)", nativeQuery=true)
	public List<Object[]> getAllCustomFromIdToMax(Integer id);
}
