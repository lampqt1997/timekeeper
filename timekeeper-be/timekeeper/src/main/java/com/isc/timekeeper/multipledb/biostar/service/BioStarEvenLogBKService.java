package com.isc.timekeeper.multipledb.biostar.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isc.timekeeper.multipledb.biostar.entity.BioStarEvenLog;
import com.isc.timekeeper.multipledb.biostar.entity.BioStarEvenLogBK;
import com.isc.timekeeper.multipledb.biostar.repository.BioStarEvenLogBKRepository;

@Service
public class BioStarEvenLogBKService {
	@Autowired
    @PersistenceContext(unitName = "biostar")
	private EntityManager em;
	
	@Autowired
	private BioStarEvenLogBKRepository logBKRepository;
	
	public List<BioStarEvenLogBK> getAll(){
		return logBKRepository.findAll();
	}
	public Integer getCurrent() {
		return logBKRepository.getMaxId();
	}
	
	public List<BioStarEvenLogBK> getFromIdToMax(int id){
		return logBKRepository.getFromIdToMax(id);
	}
	
	public List<Object[]> getAllCustomFromIdToMax(Integer id){
		Query q =  em.createNativeQuery("select nEventLogIdn, nUserID, dateadd(s,ndatetime,'1970-01-01 00:00:00') from TB_EVENT_LOG_BK  where (nEventLogIdn between :id and (select max(nEventLogIdn) from TB_EVENT_LOG)) and (nEventIdn in (55,58,59,60,61,62))");
		q.setParameter("id", id);
		List<Object[]> list = q.getResultList();
		
		return list;
	
	}
	public List<Object[]> getAllCustom(){
		Query q =  em.createNativeQuery("select nEventLogIdn, nUserID, dateadd(s,ndatetime,'1970-01-01 00:00:00') from TB_EVENT_LOG_BK  where nEventIdn in (55,58,59,60,61,62)");
	
		List<Object[]> list = q.getResultList();
		
		return list;
	
	}
}
