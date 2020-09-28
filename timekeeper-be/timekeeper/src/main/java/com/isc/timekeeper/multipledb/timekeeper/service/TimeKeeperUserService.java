package com.isc.timekeeper.multipledb.timekeeper.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isc.timekeeper.multipledb.api.token.PasswordEncoder;
import com.isc.timekeeper.multipledb.timekeeper.dto.AccountDTO;
import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperUser;
import com.isc.timekeeper.multipledb.timekeeper.repository.TimeKeeperUserRepository;

@Service
public class TimeKeeperUserService {
	
	@Autowired
	private PasswordEncoder encode;
	
	@PersistenceContext(unitName = "timekeeper")
	@Autowired
	private EntityManager em;
	
	@Autowired
	private TimeKeeperUserRepository tkUserRepository;
	//$2a$10$fI3eYNoiwLQ5JxomRvfL9uvlQmOHNilqbFrSvF0xcN9yYgxGhRpQC
	//$2a$10$.VpfJ806B82y1N4m8orRGuk8uwMBPVwqNy8OYRZUjjBQQGw21R3fW
	//$2a$10$YeSWZcCf3QFeiSbFHzv.OO4F565wj1B2Ndf4gD6oDxJAzr95I0diu
	//$2a$10$KyQcmUVfy6ElhfskwhIDOOx8z0bwCQ8YbXkoX.w7JvN6uJrYQ.gv2

	//-- and tu.password = :password
	public boolean authenticate(AccountDTO account) {
		Query query = em.createQuery("from TimeKeeperUser tu where tu.userName = :username ");
		query.setParameter("username", account.getUsername());
//		query.setParameter("password", encode.hashPassword(account.getPassword()));
		
		System.out.println(encode.encode(account.getPassword()));
		
		TimeKeeperUser u = (TimeKeeperUser)query.getSingleResult();
		if (u==null) {
			return false;
		}
		return true;
	}


	public TimeKeeperUser getUserByUserName(String username) {
		Query query = em.createQuery("from TimeKeeperUser tu where tu.userName = :username ");
		query.setParameter("username", username);
		
		return (TimeKeeperUser) query.getSingleResult();
	}


	public TimeKeeperUser save(TimeKeeperUser user) {
		return tkUserRepository.saveAndFlush(user);
	}

}
