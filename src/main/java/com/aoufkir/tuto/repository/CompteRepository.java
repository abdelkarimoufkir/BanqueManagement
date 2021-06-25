package com.aoufkir.tuto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aoufkir.tuto.entity.Clients;
import com.aoufkir.tuto.entity.Comptes;

@Repository
public interface CompteRepository extends CrudRepository<Comptes, Long> {
	
	List<Comptes> findByclientcode(Clients id);
	Comptes findBycodeCompte(String Codecompte);

}
