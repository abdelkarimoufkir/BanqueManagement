package com.aoufkir.tuto.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.aoufkir.tuto.entity.Comptes;
import com.aoufkir.tuto.entity.Operations;

public interface OperationService {

	Iterable<Operations> listOperations();
	Page<Operations> findByCompteID(Comptes compte, int page, int size);
	Operations EnregistrerOperation(Operations operation);
	void Versement(String compte, double montant, String type);
	void Retrait(String compte, double montant, String type);
	void Virement(String compte1, String compte2, double montant, String type);
	
}
