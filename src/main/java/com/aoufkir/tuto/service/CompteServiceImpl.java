package com.aoufkir.tuto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aoufkir.tuto.entity.Clients;
import com.aoufkir.tuto.entity.Comptes;
import com.aoufkir.tuto.repository.CompteRepository;

@Service
@Transactional
public class CompteServiceImpl implements CompteService {

	@Autowired
	private CompteRepository compterepository;
	
	@Override
	public Comptes EnregistrerCompte(Comptes compte) {
		return compterepository.save(compte);
	}

	@Override
	public Iterable<Comptes> ListComptes() {
		return compterepository.findAll();
	}

	@Override
	public Comptes findCompteById(long id) {
		return compterepository.findById(id).orElse(null);
	}

	@Override
	public void DeleteCompte(long id) {
		compterepository.deleteById(id);

	}

	@Override
	public List<Comptes> findCompteByclientcode(Clients id) {
		return compterepository.findByclientcode(id);
	}

	@Override
	public Comptes findCompteByCode(String Codecompte) {
		return compterepository.findBycodeCompte(Codecompte);
	}

	

}
