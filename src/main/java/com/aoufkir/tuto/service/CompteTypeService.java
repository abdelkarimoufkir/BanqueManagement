package com.aoufkir.tuto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.aoufkir.tuto.entity.CompteTypes;
import com.aoufkir.tuto.repository.CompteTypesRepository;

@Service
@Transactional
public class CompteTypeService {

	
	@Autowired
	CompteTypesRepository comptetyperepository;
	
	public Iterable<CompteTypes> listeCompteType(){
		
		return comptetyperepository.findAll();
	}
	
	public CompteTypes AddCompteTypes(CompteTypes comptetype) {
		return comptetyperepository.save(comptetype);
		
	}
}
