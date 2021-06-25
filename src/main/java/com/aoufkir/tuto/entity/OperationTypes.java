package com.aoufkir.tuto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="operation_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationTypes {
	
	@Id
	@Column(name = "Operation_TYPE_CODE")
	private String operationTypeCode;
	
	@Column(name = "Operation_DESCRIPTION")
	private String operationTypeDesciption;

}
