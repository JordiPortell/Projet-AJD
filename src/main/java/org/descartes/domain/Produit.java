package org.descartes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produit {
long idProd;
String Libelle;
String Type;
double Prix;
double Note;
String ImagePATH;
Origine OrigineProduit;

public Produit(){
	super();
}

public Produit(String libelle,String type,double prix,double note,String imagePATH,Origine origineProduit){
	super();
	Libelle = libelle;
	Type = type;
	Prix = prix;
	Note = note;
	ImagePATH = imagePATH;
	OrigineProduit=origineProduit;
}

public String getImagePATH() {
	return ImagePATH;
}

public void setImagePATH(String imagePATH) {
	ImagePATH = imagePATH;
}


@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public long getId() {
	return idProd;
}

public void setId(long id) {
	this.idProd = id;
}

public String getLibelle() {
	return Libelle;
}

public void setLibelle(String libelle) {
	Libelle = libelle;
}

public String getType() {
	return Type;
}

public double getNote() {
	return Note;
}

public void setNote(double note) {
	Note = note;
}

public void setType(String type) {
	Type = type;
}

public double getPrix() {
	return Prix;
}

public void setPrix(double prix) {
	this.Prix = prix;
}



}
