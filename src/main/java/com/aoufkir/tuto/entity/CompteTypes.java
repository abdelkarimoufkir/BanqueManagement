package com.aoufkir.tuto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="compte_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompteTypes {

	@Id
	@Column(name = "Compte_TYPE_CODE")
	private String compteTypeCode;
	
	@Column(name = "Compte_DESCRIPTION")
	private String compteTypeDesciption;
}
