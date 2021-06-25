package com.aoufkir.tuto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.aoufkir.tuto.entity.Comptes;
import com.aoufkir.tuto.entity.OperationTypes;
import com.aoufkir.tuto.entity.Operations;
import com.aoufkir.tuto.repository.OperationRepository;

@Service
public class OperationServImpl implements OperationService {

	@Autowired
	private OperationRepository operationrepo;

	@Autowired
	private CompteService compteservice;

	@Autowired
	private OperationTypSservice operationtypeservice;

	OperationTypes operationtype = new OperationTypes();

	@Override
	public Iterable<Operations> listOperations() {
		return operationrepo.findAll();
	}

	@Override
	public Page<Operations> findByCompteID(Comptes compte, int page, int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "dateOperation"));
		return operationrepo.findOperationsBycompteID(compte, pageable);
	}

	@Override
	public Operations EnregistrerOperation(Operations operation) {
		return operationrepo.save(operation);
	}

	@Override
	public void Versement(String codeCompte, double montant, String type) {
		Operations operation = new Operations();
		Comptes compte = compteservice.findCompteByCode(codeCompte);
		this.operationtype = operationtypeservice.findOperationTypeBycode(type);
		operation.setCompteID(compte);
		operation.setOprationTypeID(this.operationtype);
		operation.setMontant(montant);
		compte.setSolde(compte.getSolde() + montant);
		compteservice.EnregistrerCompte(compte);
		this.EnregistrerOperation(operation);

	}

	@Override
	public void Retrait(String codeCompte, double montant, String type) {
		Operations operation = new Operations();
		Comptes compte = compteservice.findCompteByCode(codeCompte);
		this.operationtype = operationtypeservice.findOperationTypeBycode(type);
		operation.setCompteID(compte);
		operation.setOprationTypeID(this.operationtype);
		operation.setMontant(montant);
		compte.setSolde(compte.getSolde() - montant);
		compteservice.EnregistrerCompte(compte);
		this.EnregistrerOperation(operation);

	}

	@Override
	public void Virement(String codeCompte1, String codeCompte2, double montant, String type) {
		Comptes compte = compteservice.findCompteByCode(codeCompte2);
		if (compte == null)
			throw new RuntimeException("Erreur : Veuillez entrez un compte existant");
		if (codeCompte1.equals(codeCompte2))
			throw new RuntimeException("Erreur : Impossibile de faire un virement sur le même compte");
		if (codeCompte2.isEmpty())
			throw new RuntimeException("Erreur : Veuillez entrez un compte existant");
		else
			Retrait(codeCompte1, montant, type);
			Versement(codeCompte2, montant, type);

	}

}
