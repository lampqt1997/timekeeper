package com.isc.timekeeper.multipledb.timekeeper.entity;

import java.io.Serializable;
import java.time.LocalDate;
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

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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
@EqualsAndHashCode(exclude = {"employeeId"})
@ToString(exclude = {"evenLogs","employeeShifts"})
@Table(name="employees")
public class TimeKeeperEmployee implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@NotFound(action = NotFoundAction.IGNORE)
	@Column(name="eId", unique=true, nullable=false)
	private Integer employeeId;
	@Column(name="boEId")
	private Integer biostartEmployeeId;
	
	
	@Column(name="eCode")
	private String employeeCode;
	@Nationalized
	@Column(name="eFirstName")
	private String firstName;
	@Nationalized
	@Column(name="eLasttName")
	private String lastName;
	@Column(name="eStartDate")
	private LocalDate startDate;
	@Column(name="eEndDate")
	private LocalDate endDate;
	@Column(name="eAddress")
	private String address;
	@Column(name="ePhoneNumber")
	private String phoneNumber;
	private Boolean isDisable;

	@OneToMany(mappedBy = "employee")
	private List<TimeKeeperEmployeeShift> employeeShifts;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private TimeKeeperDepartment department;
	
	@ManyToOne
	@JoinColumn(name = "position_id")
	private TimeKeeperPosition position;
	
	@OneToMany(mappedBy="employee")
	private List<TimeKeeperEvenLog> evenLogs;
	
	
}
