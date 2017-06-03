package org.descartes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Personne {

	String Nom;
	long id;
	
	public Personne() {
		super();
	}

	public Personne(String nom) {
		this.Nom = nom;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		this.Nom = nom;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + Nom + "]";
	}
	
	
		
}
