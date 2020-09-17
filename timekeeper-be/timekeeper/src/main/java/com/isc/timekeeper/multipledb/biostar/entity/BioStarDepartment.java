package com.isc.timekeeper.multipledb.biostar.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"nDepartmentIdn"})
@ToString
@Table(name="TB_USER_DEPT")
public class BioStarDepartment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false)
	private Integer nDepartmentIdn;
	
	@Column(name="sName",length=64,nullable=false)
	private String sName;
	
	@Column(name="sDepartment", length=255,nullable=false)
	private String sDepartment;
	
	@Column(name="nDepth",nullable=false)
	private Short nDepth;
	
	@Column(name="nParentIdn",nullable=false)
	private Integer nParentIdn;
	
	
	
}
