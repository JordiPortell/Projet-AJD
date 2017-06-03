package org.descartes;

import org.descartes.domain.Client;
import org.descartes.domain.Commande;
import org.descartes.domain.Personne;
import org.descartes.domain.Produit;
import org.descartes.domain.Origine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestBody;
import org.descartes.services.ServiceClient;
import org.descartes.services.ServicePersonne;
import org.descartes.services.ServiceProduit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AjoutProduits {

	@Test
	public void contextLoads() {
	
		ServiceProduit servicepro = new ServiceProduit();
		Origine ori1=new Origine("Corrèze");
		Origine ori2=new Origine("Rhone-Alpe");
		Produit pro1 = new Produit("La rosette du Chatoux","rosette",8,3.9,"https://i.imgur.com/D34nH3O.jpg",ori1);
		Produit pro2 = new Produit("La saucisson fumé de Snoop Doggy Dog","fumé",6.5,3.9,"https://i.imgur.com/D34nH3O.jpg",ori1);
		Produit pro3 = new Produit("Saucisson bien dur à la noisette","noisette",5.99,4.1,"https://i.imgur.com/j7joFKJ.jpg",ori2);
		servicepro.addProduit(pro1); 
		servicepro.addProduit(pro2); 
		servicepro.addProduit(pro3); 
	
		//System.out.println(pro1.toString());
	}

}