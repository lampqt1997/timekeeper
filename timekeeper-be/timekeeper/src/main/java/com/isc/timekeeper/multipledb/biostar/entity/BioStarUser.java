package com.isc.timekeeper.multipledb.biostar.entity;

import java.math.BigInteger;

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
@EqualsAndHashCode(exclude = { "nDepartmentIdn" })
@ToString
@Table(name = "TB_USER")
public class BioStarUser {
	@Id
	private Integer nUserIdn;
	private String sUserName;
	private Integer nDepartmentIdn;
	private String sTelNumber; // varchar(64) Unchecked
	private String sEmail; // nvarchar(100) Unchecked
	private String sUserID; // varchar(64) Unchecked
	private String sPassword; // varchar(64) Unchecked
	private byte[] bPassword2; // binary(32) Unchecked
	private Integer nStartDate; // int Unchecked
	private Integer nEndDate; // int Unchecked
	private Integer nAdminLevel; // int Unchecked
	private Integer nAuthMode; // int Unchecked
	private Integer nAuthLimitCount; // int Unchecked
	private Integer nTimedAPB; // int Unchecked
	private Integer nEncryption; // int Unchecked

}
