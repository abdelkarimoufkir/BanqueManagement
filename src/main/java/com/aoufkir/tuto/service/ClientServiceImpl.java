package com.aoufkir.tuto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aoufkir.tuto.entity.Clients;
import com.aoufkir.tuto.repository.ClientRepository;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientrepository;
	
	@Override
	public Clients SaveClient(Clients client) {
		return clientrepository.save(client);
	}

	@Override
	public void DeleteClient(long id) {
		clientrepository.deleteById(id);
	}

	@Override
	public Iterable<Clients> ListeClients() {
		return clientrepository.findAll();
	}

	@Override
	public Clients FindClientByID(long id) {
		return clientrepository.findById(id).orElse(null);
	}

}
