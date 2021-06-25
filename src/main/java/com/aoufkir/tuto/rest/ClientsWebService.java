package com.aoufkir.tuto.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aoufkir.tuto.entity.Clients;
import com.aoufkir.tuto.service.ClientService;

@RestController
public class ClientsWebService {
	
	@Autowired
	private ClientService clientservice;
	
	
	@GetMapping(value="/api/clients")
	public Iterable<Clients> listClientsWS(){
		
		return clientservice.ListeClients();
	}
	
	
	@GetMapping(value="/api/clients/{id}")
	public Clients GetClientsById(@PathVariable("id") long id){
		
		return clientservice.FindClientByID(id);
	}

}
