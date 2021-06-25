package com.aoufkir.tuto.repository;

import org.springframework.data.repository.CrudRepository;

import com.aoufkir.tuto.entity.Clients;

public interface ClientRepository extends CrudRepository<Clients, Long> {

}
