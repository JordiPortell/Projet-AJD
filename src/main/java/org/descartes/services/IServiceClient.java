package org.descartes.services;

import java.util.List;

import org.descartes.domain.Client;

public interface IServiceClient {
	
	public Client findClient(String nom);
	
	public List<?> findAll();
	
	public void addClient(Client client);
}
