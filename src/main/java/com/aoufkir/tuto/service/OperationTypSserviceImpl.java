package com.aoufkir.tuto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aoufkir.tuto.entity.OperationTypes;
import com.aoufkir.tuto.repository.OperationTypeRepository;

@Service
public class OperationTypSserviceImpl implements OperationTypSservice {

	@Autowired
	private OperationTypeRepository operationTyperepository;
	
	@Override
	public Iterable<OperationTypes> listOperationType() {
		return operationTyperepository.findAll();
	}

	@Override
	public OperationTypes findOperationTypeBycode(String code) {
		return operationTyperepository.findById(code).orElse(null);
	}

}
