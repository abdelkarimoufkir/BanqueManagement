package com.aoufkir.tuto.service;

import com.aoufkir.tuto.entity.OperationTypes;

public interface OperationTypSservice {

	Iterable<OperationTypes> listOperationType ();
	OperationTypes findOperationTypeBycode(String code);
}
