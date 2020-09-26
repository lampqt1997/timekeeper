package com.isc.timekeeper.multipledb.timekeeper.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperEvenLog;
import com.isc.timekeeper.multipledb.timekeeper.repository.TimeKeeperEvenLogRepository;

@Service
public class TimeKeeperEvenLogService {

	@PersistenceContext(unitName = "timekeeper")
	@Autowired
	private EntityManager em;

	@Autowired
	private TimeKeeperEvenLogRepository tkEvenLogRepository;

	public List<TimeKeeperEvenLog> getAll() {
		return tkEvenLogRepository.findAll();
	}

	public Integer getCurrent() {
		return tkEvenLogRepository.getMaxId();
	}

	public void saveAll(List<TimeKeeperEvenLog> list) {
		tkEvenLogRepository.saveAll(list);
	}
	public List<TimeKeeperEvenLog> getTimeKeeper(int page, int numberOfResult,LocalDate date) {
		int offset = numberOfResult * (page-1);

		Query query = em.createNativeQuery(
				"select * from evenlogs ev where year(ev.checkDate) = :y and month(ev.checkDate) = :m and day(ev.checkDate) = :d order by ev.employee_id OFFSET :offset ROWS FETCH NEXT :limit ROWS ONLY");
		query.setParameter("y", date.getYear());
		query.setParameter("m", date.getMonthValue());
		query.setParameter("d", date.getDayOfMonth());
		query.setParameter("offset", offset);
		query.setParameter("limit", numberOfResult);
		List<TimeKeeperEvenLog> listEvents = query.getResultList();
		return  listEvents;
	}
	
	public List<TimeKeeperEvenLog> getTimeKeepeAtCurrentDay(int page, int numberOfResult) {

		int offset = numberOfResult * (page-1);
		LocalDate today = LocalDate.now();
		
		Query query = em.createNativeQuery(
				"select * from evenlogs ev where year(ev.checkDate) = :y and month(ev.checkDate) = :m and day(ev.checkDate) = :d order by ev.employee_id OFFSET :offset ROWS FETCH NEXT :limit ROWS ONLY");
		query.setParameter("y", today.getYear());
		query.setParameter("m", today.getMonthValue());
		query.setParameter("d", today.getDayOfMonth());
		query.setParameter("offset", offset);
		query.setParameter("limit", numberOfResult);
		List<TimeKeeperEvenLog> listEvents = query.getResultList();
		return  listEvents;

	}

	public int countRecordCurrent() {
		LocalDate today = LocalDate.now();
		Query query = em.createNativeQuery(
				"select count(ev.evenlog_id) from evenlogs ev where (year(ev.checkDate) = :y ) and (month(ev.checkDate) = :m ) and ( day(ev.checkDate) = :d ) ");
		query.setParameter("y", today.getYear());
		query.setParameter("m", today.getMonthValue());
		query.setParameter("d", today.getDayOfMonth());
		
		return  (int) query.getSingleResult();
	}
	
	public int countRecordByDate(LocalDate date) {
		Query query = em.createNativeQuery(
				"select count(evenlog_id) from evenlogs where year(checkDate) = :y and month(checkDate) = :m and day(checkDate) = :d ");
		query.setParameter("y", date.getYear());
		query.setParameter("m", date.getMonthValue());
		query.setParameter("d", date.getDayOfMonth());
		return  (int) query.getSingleResult();
	}

}
