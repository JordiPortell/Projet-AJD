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
		String Query = new String("'%"+query.toUpperCase()+"%'");
		Query = ""
				+ "SELECT * "
				+ "FROM PRODUIT p "
				+ "WHERE UPPER(p.LIBELLE) LIKE "+Query+" "
				+ "OR UPPER(p.TYPE) LIKE "+Query+" "
				+ "OR p.ORIGINEPRODUIT_ID IN "
				+ "(SELECT o.ID "
				+ "FROM ORIGINE o "
				+ "WHERE UPPER(o.LIBELLE) LIKE "+Query+")";
		Query req = entityManager.createNativeQuery(Query, Produit.class);
		List liste = (List) req.getResultList();
		return liste;
	}
	

}
