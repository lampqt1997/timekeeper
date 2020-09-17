package com.isc.timekeeper.multipledb.timekeeper.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@EqualsAndHashCode(exclude = {"employeeShiftId"})
@ToString(exclude = {""})
@Table(name="employeeshifts")
public class TimeKeeperEmployeeShift implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="emshift_id", unique=true, nullable=false)
	private Integer employeeShiftId;
	
	private LocalDate fromDate;
	private LocalDate toDate;
	
	private Boolean isDisable;
	@ManyToOne
	@JoinColumn(name = "shift_id")
	private TimeKeeperShift shift;
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private TimeKeeperEmployee employee;
	
	
	
}
