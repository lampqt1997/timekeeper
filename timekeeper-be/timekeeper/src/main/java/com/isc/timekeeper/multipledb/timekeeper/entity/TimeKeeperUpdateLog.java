package com.isc.timekeeper.multipledb.timekeeper.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
@EqualsAndHashCode(exclude = {"updateLogId"})
@ToString(exclude = {""})
@Table(name="updatelogs")

public class TimeKeeperUpdateLog implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="updatelog_id", unique=true, nullable=false)
	private Integer updateLogId;
	
	@Column(name = "modified_date")
	private LocalDateTime timeUpdate;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private TimeKeeperUser user;
	
	@ManyToOne
	@JoinColumn(name="evenlog_id")
	private TimeKeeperEvenLog evenLog;
	
}
