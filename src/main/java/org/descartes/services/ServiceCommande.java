package org.descartes.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.descartes.domain.Client;
import org.descartes.domain.Commande;

public class ServiceCommande {
EntityManager entityManager;
	
	public ServiceCommande() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		entityManager = emf.createEntityManager();
	}
	
	public Commande findClient(int num){
		List<Commande> liste = entityManager.createQuery( "SELECT c FROM Commande c WHERE c.num = :namePerson" )
				.setParameter( "namePerson", num)
				.getResultList();
		return (Commande) liste.get(0);
	}
	
	public List<?> findAll(){
		List liste = entityManager.createQuery( "SELECT c FROM Commande c" )
				.getResultList();
		return liste;
	}
	
	public void addCommande(Commande Commande){
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(Commande);
		tx.commit();
	}
}
