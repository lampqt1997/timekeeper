package com.isc.timekeeper.multipledb.timekeeper.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isc.timekeeper.multipledb.timekeeper.dto.TimeKeeperSpecialDayDTO;
import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperSpecialDay;
import com.isc.timekeeper.multipledb.timekeeper.repository.TimeKeeperSpecialDayRepository;

@Service
public class TimeKeeperSpecialDayService {

	@PersistenceContext(unitName = "timekeeper")
	@Autowired
	private EntityManager em;

	@Autowired
	private TimeKeeperSpecialDayRepository tkSpecialDayRepository;
	
	public List<TimeKeeperSpecialDay> getAll(){
Query query = em.createQuery("from TimeKeeperSpecialDay  t where (t.isDisable = 0 or t.isDisable is null) ");
		
		List<TimeKeeperSpecialDay> list = query.getResultList();
		return list;
	}
	
	public List<TimeKeeperSpecialDay> getAllInCurrentYear() {
		Query query = em.createQuery("from TimeKeeperSpecialDay  t where (t.isDisable = 0 or t.isDisable is null) and  (FUNCTION('YEAR', t.spdate) =  FUNCTION('YEAR',FUNCTION('GETDATE' ) ) )");
		
		List<TimeKeeperSpecialDay> list = query.getResultList();
		return list;
	}

	public TimeKeeperSpecialDay add(TimeKeeperSpecialDay t) {
		return tkSpecialDayRepository.saveAndFlush(t);
	}

	@Transactional(transactionManager = "timekeeperTransactionManager")
	public int update(TimeKeeperSpecialDayDTO tk) {
		Query query = em.createQuery("update TimeKeeperSpecialDay  set spName = :name where spdate = :date");
		query.setParameter("name", tk.getTitle());
		query.setParameter("date", tk.getDate());

		return query.executeUpdate();
	}

	public Optional<TimeKeeperSpecialDay> get(int id) {

		return tkSpecialDayRepository.findById(id);
	}

	@Transactional(transactionManager = "timekeeperTransactionManager")
	public int delete(LocalDate date) {
		Query query = em.createQuery("update TimeKeeperSpecialDay  set isDisable = true where spdate = :date");
		query.setParameter("date", date);
		return query.executeUpdate();

	}
}
