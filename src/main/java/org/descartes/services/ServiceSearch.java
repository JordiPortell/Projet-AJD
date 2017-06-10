package org.descartes.services;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.descartes.domain.Produit;
import org.descartes.domain.Origine;

public class ServiceSearch {
EntityManager entityManager;
	
	public ServiceSearch() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		entityManager = emf.createEntityManager();
	}
	
	
	public List<?> findAll(String query){
		List liste = entityManager.createQuery( "SELECT p FROM PRODUIT p WHERE p.LIBELLE LIKE '%"+query+"'% OR p.TYPE LIKE '%"+query+"%' "
				+ "OR p.ORIGINEPRODUIT_ID IN (SELECT o.LIBELLE FROM ORIGINE o WHERE o.LIBELLE LIKE '%"+query+"%')")
				.getResultList();
		return liste;
	}
	

}
