package org.descartes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Origine {
	
long idOri;
String Libelle;

public Origine() {
	super();
}

public Origine(String libelle) {
	super();
	this.Libelle = libelle;
}

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public long getId() {
	return idOri;
}

public void setId(long id) {
	this.idOri = id;
}

public String getLibelle() {
	return Libelle;
}

public void setLibelle(String libelle) {
	this.Libelle = libelle;
}



}
