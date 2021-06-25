package com.aoufkir.tuto.service;


import java.util.List;

import com.aoufkir.tuto.entity.Clients;
import com.aoufkir.tuto.entity.Comptes;

public interface CompteService {
	
	Comptes EnregistrerCompte(Comptes compte);
	Iterable<Comptes> ListComptes ();
	Comptes findCompteById(long id);
	void DeleteCompte(long id);
	Comptes findCompteByCode(String Codecompte );
	List<Comptes> findCompteByclientcode(Clients id);

}
