package com.isc.timekeeper.multipledb.biostar.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isc.timekeeper.multipledb.biostar.entity.BioStarEvenLog;
import com.isc.timekeeper.multipledb.biostar.entity.BioStarUser;
import com.isc.timekeeper.multipledb.biostar.repository.BioStarUserRepository;

@Service
public class BioStarUserService {
	@Autowired
    @PersistenceContext(unitName = "biostar")
	private EntityManager em;
	@Autowired
	private BioStarUserRepository userSeftRepository;
	
	public List<BioStarUser> getAll(){
		return userSeftRepository.findAll();
	}

	public List<Object[]> getFromIdToMax(Integer idEmployeeMax) {
		Query q =  em.createNativeQuery("select  u1.nUserIdn , u1.sUserID, u1.sUserName ,dateadd(s,u1.nStartDate,'1970-01-01 00:00:00') as startdate,dateadd(s, u1.nEndDate,'1970-01-01 00:00:00') as enddate, u1.sTelNumber, u1.nDepartmentIdn from TB_USER u1  where u1.nUserIdn between :id and (select max(u2.nUserIdn) from TB_USER u2)");
		q.setParameter("id", idEmployeeMax);
		List<Object[]> list = q.getResultList();
		return list;
	}
}
