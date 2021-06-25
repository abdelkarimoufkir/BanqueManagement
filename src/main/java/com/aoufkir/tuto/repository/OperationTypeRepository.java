package com.aoufkir.tuto.repository;

import org.springframework.data.repository.CrudRepository;

import com.aoufkir.tuto.entity.OperationTypes;

public interface OperationTypeRepository extends CrudRepository<OperationTypes, String> {

}
