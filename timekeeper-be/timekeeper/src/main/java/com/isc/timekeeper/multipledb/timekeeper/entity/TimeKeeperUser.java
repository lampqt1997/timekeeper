package com.isc.timekeeper.multipledb.timekeeper.entity;

import java.io.Serializable;
import java.time.LocalDate;
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
@EqualsAndHashCode(exclude = {"userId"})
@ToString(exclude = {"updateLogs"})
@Table(name="users")

public class TimeKeeperUser implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="uId", unique=true, nullable=false)
	private Integer userId;
	@Column(name="username")
	private String userName;
	
	private String password;
	
	@Nationalized
	private String firstName;
	
	private String email;
	
	private String phoneNumber;
	
	private Boolean isDisable;
	
	@OneToMany(mappedBy="user")
	private List<TimeKeeperUpdateLog> updateLogs;
	
}
