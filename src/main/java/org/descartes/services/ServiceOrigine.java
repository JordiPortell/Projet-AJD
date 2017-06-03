package org.descartes.services;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.descartes.domain.Produit;

public class ServiceOrigine {
EntityManager entityManager;
	
	public ServiceOrigine() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		entityManager = emf.createEntityManager();
	}

	
	public List<?> findAll(){
		List liste = entityManager.createQuery( "SELECT o FROM Origine o" )
				.getResultList();
		return liste;
	}
	

}
