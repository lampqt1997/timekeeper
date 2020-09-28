package com.isc.timekeeper.multipledb.biostar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isc.timekeeper.multipledb.biostar.entity.BioStarDepartment;

@Repository
public interface BioStarDepartmentRepository extends JpaRepository<BioStarDepartment, Integer> {

	@Query(value = "select max(nDepartmentIdn) from BioStarDepartment  ")
	public Integer getMaxId();

	@Query(value = "from BioStarDepartment where nDepartmentIdn between :id and (select max(nDepartmentIdn) from BioStarDepartment)")
	public List<BioStarDepartment> getFromIdToMax(Integer id);
}
