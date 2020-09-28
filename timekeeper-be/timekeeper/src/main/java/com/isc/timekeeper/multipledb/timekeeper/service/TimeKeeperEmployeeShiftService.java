package com.isc.timekeeper.multipledb.timekeeper.service;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperEmployeeShift;

@Service
public class TimeKeeperEmployeeShiftService {

	@PersistenceContext(unitName = "timekeeper")
	@Autowired
	private EntityManager em;
	
	
	public TimeKeeperEmployeeShift getShiftByDateAndEmployeeCode(LocalDate date, String eCode) {
		Query query = em.createNativeQuery("SELECT * from employeeshifts where  employee_Code = :eCode  and (:date between fromDate and toDate)", TimeKeeperEmployeeShift.class);
		query.setParameter("eCode", eCode);
		query.setParameter("date", date);
		
		return  (TimeKeeperEmployeeShift) query.getSingleResult();
	}

}
