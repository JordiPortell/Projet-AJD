package org.descartes.domain;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {

	private String nom;
	private String prenom;
	private long idCli;
	private String adresse;
	private String typeAbonnement;
	private String login;
	private String password;
	private List<Commande> ListCommande= new ArrayList();
	
	public String getTypeAbonnement() {
		return typeAbonnement;
	}

	public void setTypeAbonnement(String typeAbonnement) {
		this.typeAbonnement = typeAbonnement;
	}

	
	
	public Client() {
		super();
	}

	public Client(String nom,String prenom,String adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<Commande> getListCommande() {
		return ListCommande;
	}
	
	public void setCommande(List<Commande> List){
		this.ListCommande= List;
		}
	
		public void addCommande(Commande commande){
		this.ListCommande.add(commande);
		}

		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return idCli;
	}

	public void setId(long id) {
		this.idCli = id;
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + "]";
	}
	
	
		
}

