package com.isc.timekeeper.multipledb.biostar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isc.timekeeper.multipledb.biostar.entity.BioStarEvenLogBK;
import com.isc.timekeeper.multipledb.biostar.repository.BioStarEvenLogBKRepository;

@Service
public class BioStarEvenLogBKService {
	
	@Autowired
	private BioStarEvenLogBKRepository logBKRepository;
	
	public List<BioStarEvenLogBK> getAll(){
		return logBKRepository.findAll();
	}
}
