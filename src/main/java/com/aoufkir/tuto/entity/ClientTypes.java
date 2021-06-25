package com.aoufkir.tuto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="client_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientTypes {
	
	@Id
	@Column(name = "CL_TYPE_CODE")
	private String clientTypeCode;
	
	@Column(name = "CL_DESCRIPTION")
	private String clientTypeDesciption;
	
}
