package org.descartes.services;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.descartes.domain.Produit;

public class ServiceProduit {
EntityManager entityManager;
	
	public ServiceProduit() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		entityManager = emf.createEntityManager();
	}
	
	public Produit findProduit(long id){
		System.out.println(id);
		String sql = "SELECT Produit.* FROM Produit AS Produit WHERE ID = ?";
		Query query = entityManager.createNativeQuery(sql, Produit.class);
		query.setParameter(1, id);
		Produit produit = (Produit) query.getSingleResult();
		return produit;
	}
	
	public List<?> findAll(){
		List liste = entityManager.createQuery( "SELECT p FROM Produit p" )
				.getResultList();
		return liste;
	}
	
	public void addProduit(Produit produit){
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(produit);
		tx.commit();
	}
}
