package com.isc.timekeeper.multipledb.timekeeper.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

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
@EqualsAndHashCode(exclude = {"departmentId"})
@ToString(exclude = {""})
@Table(name="departments")
public class TimeKeeperDepartment implements Serializable {
	@Id
//	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="departmen_id", unique=true, nullable=false)
	private Integer departmentId;
	@Nationalized
	private String dName;
	
	private Boolean isDisable;
	
}
