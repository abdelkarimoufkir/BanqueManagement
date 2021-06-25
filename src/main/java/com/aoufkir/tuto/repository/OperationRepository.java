package com.aoufkir.tuto.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aoufkir.tuto.entity.Comptes;
import com.aoufkir.tuto.entity.Operations;

@Repository
public interface OperationRepository extends CrudRepository<Operations, Long> {
	
	Page<Operations> findOperationsBycompteID(Comptes compte, Pageable peagable);
}
