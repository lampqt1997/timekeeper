package com.isc.timekeeper.multipledb.timekeeper.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@EqualsAndHashCode(exclude = {"shiftId"})
@ToString(exclude = {""})
@Table(name="shifts")

public class TimeKeeperShift implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="shift_id", unique=true, nullable=false)
	private Integer shiftId;
	@Nationalized
	private String shiftCode;
	@Nationalized
	private String shiftName;
	private LocalTime startHour;
	private LocalTime finishHour;
	private double shiftCoefficient;
	private Integer dayOfWeek;
	private Boolean isDisable;
	
	@OneToMany(mappedBy="shift")
	private List<TimeKeeperEmployeeShift> employeeShifts;
	
	
}
