package com.aoufkir.tuto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aoufkir.tuto.entity.ClientTypes;
import com.aoufkir.tuto.repository.ClientTypesRepository;

@Service
@Transactional
public class ClientTypeService {
	
	@Autowired
	ClientTypesRepository clienttyperepository;
	
	public Iterable<ClientTypes> listeClientType(){
		
		return clienttyperepository.findAll();
	}
	
	public ClientTypes AddClientTypes(ClientTypes clienttype) {
		return clienttyperepository.save(clienttype);
		
	}

}
