package com.isc.timekeeper.multipledb.timekeeper.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@EqualsAndHashCode(exclude = {"evenLogId"})
@ToString(exclude = {"employee"})
@Table(name="evenlogs")

public class TimeKeeperEvenLog implements Serializable {
	@Id
//	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="evenlog_id", unique=true, nullable=false)
	private Integer evenLogId;
	
	private LocalDateTime checkDate;
	
	private Boolean isDisable;	
	
	private LocalDateTime timeCreated;
	
	@ManyToOne()
	@JoinColumn(name="employee_id")
	private TimeKeeperEmployee employee;
	
	@OneToMany(mappedBy="evenLog")
	private List<TimeKeeperUpdateLog> updateLogs;

	public TimeKeeperEvenLog(Integer evenLogId, LocalDateTime checkDate, Boolean isDisable, LocalDateTime timeCreated,
			TimeKeeperEmployee employee) {
		super();
		this.evenLogId = evenLogId;
		this.checkDate = checkDate;
		this.isDisable = isDisable;
		this.timeCreated = timeCreated;
		this.employee = employee;
	}
	
	
}
