package com.aoufkir.tuto.repository;

import org.springframework.data.repository.CrudRepository;

import com.aoufkir.tuto.entity.ClientTypes;
import com.aoufkir.tuto.entity.CompteTypes;

public interface CompteTypesRepository extends CrudRepository<CompteTypes, String> {

}
