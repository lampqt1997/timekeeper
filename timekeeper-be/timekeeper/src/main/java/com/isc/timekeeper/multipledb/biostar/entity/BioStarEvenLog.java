package com.isc.timekeeper.multipledb.biostar.entity;

import javax.persistence.Entity;
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
@Table(name="TB_EVENT_LOG")
public class BioStarEvenLog {
	@Id
	private Integer nEventLogIdn; // int
	private Integer nDateTime; // int
	private Integer nReaderIdn; // int
	private Integer nEventIdn; // int
	private Integer nUserID;// int
	private Short nIsLog; // smallint
	private Short nTNAEvent; // smallint
	private Short nIsUseTA; // smallint
	private Short nType; // smallint
}
