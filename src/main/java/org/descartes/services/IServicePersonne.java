package org.descartes.services;

import java.util.List;

import org.descartes.domain.Personne;

public interface IServicePersonne {

	
	public Personne findPersonne(String nom);
	
	public List<?> findAll();
	
	public void addPersonne(Personne personne);
}
