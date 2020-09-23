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
	private Byte[] dayOfWeek;
	private Boolean isDisable;
	
	@OneToMany(mappedBy="shift")
	private List<TimeKeeperEmployeeShift> employeeShifts;

	public TimeKeeperShift(String shiftCode, String shiftName, LocalTime startHour, LocalTime finishHour,
			double shiftCoefficient, Byte[] dayOfWeek, Boolean isDisable) {
		super();
		this.shiftCode = shiftCode;
		this.shiftName = shiftName;
		this.startHour = startHour;
		this.finishHour = finishHour;
		this.shiftCoefficient = shiftCoefficient;
		this.dayOfWeek = dayOfWeek;
		this.isDisable = isDisable;
	}
	
	
}
