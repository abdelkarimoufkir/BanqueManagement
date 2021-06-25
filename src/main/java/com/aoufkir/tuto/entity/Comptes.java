package com.aoufkir.tuto.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comptes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comptes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="code_compte")
	private String codeCompte;
	
	@Column(name="Date_Ouverture", 
			insertable = false, 
			updatable = false , 
			nullable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date dateOuverture;
	
	@Column(name="solde")
	private double solde;
	
	@ManyToOne
	@JoinColumn(name = "Compte_TYPE_CODE", referencedColumnName = "Compte_TYPE_CODE", nullable = false)
	private CompteTypes comptetype;
	
	@ManyToOne
	@JoinColumn(name = "Client_CODE", referencedColumnName = "id", nullable = false)
	private Clients clientcode;
	
	
}
