package com.isc.timekeeper.multipledb.biostar.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.isc.timekeeper.multipledb.biostar.entity.BioStarEvenLog;
import com.isc.timekeeper.multipledb.biostar.repository.BioStarEvenLogRepository;

@Service
public class BioStarEvenLogService {

	@Autowired
    @PersistenceContext(unitName = "biostar")
	private EntityManager em;
	
	@Autowired
	private BioStarEvenLogRepository logRepository;
	
	public List<BioStarEvenLog> getAll(){
		return logRepository.findAll();
	}
	public Integer getCurrent() {
		return logRepository.getMaxId();
	}
	
	public List<BioStarEvenLog> getFromIdToMax(int id){
		return logRepository.getFromIdToMax(id);
	}
	
	public List<Object[]> getAllCustomFromIdToMax(Integer id){
		Query q =  em.createNativeQuery("select nEventLogIdn, nUserID, dateadd(s,ndatetime,'1970-01-01 00:00:00') from TB_EVENT_LOG  where nEventLogIdn between :id and (select max(nEventLogIdn) from TB_EVENT_LOG)");
		q.setParameter("id", id);
		List<Object[]> list = q.getResultList();
		
		return list;
	
	}
}
