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
@Table(name = "operations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operations {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="Date_Operations", 
			insertable = false, 
			updatable = false , 
			nullable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date dateOperation;
	
	@Column(name="montant") 
	private double montant;
	
	@ManyToOne
	@JoinColumn(name = "Compte_CODE", referencedColumnName = "id", nullable = false)
	private Comptes compteID;
	
	@ManyToOne
	@JoinColumn(name = "Operation_Type_CODE", referencedColumnName = "Operation_TYPE_CODE", nullable = false)
	private OperationTypes oprationTypeID;
}
