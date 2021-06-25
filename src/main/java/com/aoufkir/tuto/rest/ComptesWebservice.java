package com.aoufkir.tuto.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aoufkir.tuto.entity.Comptes;
import com.aoufkir.tuto.service.CompteService;

@RestController
public class ComptesWebservice {
	
	@Autowired
	private CompteService compteservice;
	
	@RequestMapping(value = "/api/comptes/")
	@GetMapping
	public Iterable<Comptes> listComptesWS(){
		return compteservice.ListComptes();
	}
	
	@RequestMapping(value = "/api/comptes/{code}")
	@GetMapping
	public Comptes GetCompteById(@PathVariable("code") String code) {
		
		return compteservice.findCompteByCode(code);
	}

}
