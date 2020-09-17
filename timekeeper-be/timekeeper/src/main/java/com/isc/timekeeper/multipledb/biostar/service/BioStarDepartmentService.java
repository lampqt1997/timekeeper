package com.isc.timekeeper.multipledb.biostar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isc.timekeeper.multipledb.biostar.entity.BioStarDepartment;
import com.isc.timekeeper.multipledb.biostar.repository.BioStarDepartmentRepository;

@Service
public class BioStarDepartmentService {

	@Autowired
	private BioStarDepartmentRepository userDeptRepository;

//	@Transactional("transactionManager")
	public BioStarDepartment get1(int id) {
		return userDeptRepository.getOne(id);
	}
	public List<BioStarDepartment> getAll(){
		List<BioStarDepartment> list = userDeptRepository.findAll();
		return list;
	}
	public List<BioStarDepartment> getFromIdToMax(Integer id) {
		return userDeptRepository.getFromIdToMax(id);
	}

}
