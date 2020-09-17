package com.isc.timekeeper.multipledb.timekeeper.entity;

import java.io.Serializable;
import java.time.LocalDate;

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
@EqualsAndHashCode(exclude = {"positionId"})
@ToString(exclude = {""})
@Table(name="positions")

public class TimeKeeperPosition implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="position_id", unique=true, nullable=false)
	private Integer positionId;
	@Nationalized
	private String pName;
	
	private Boolean isDisable;

	public TimeKeeperPosition(String pName, Boolean isDisable) {
		super();
		this.pName = pName;
		this.isDisable = isDisable;
	}
	
	
}
