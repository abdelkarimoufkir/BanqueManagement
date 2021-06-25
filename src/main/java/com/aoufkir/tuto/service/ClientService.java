package com.aoufkir.tuto.service;

import com.aoufkir.tuto.entity.Clients;

public interface ClientService {

	 Clients SaveClient(Clients client);
	 void DeleteClient(long id);
	 Iterable<Clients> ListeClients();
	 Clients FindClientByID(long id);
}
