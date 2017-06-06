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
  Origine ori3=new Origine("Jura");
  Origine ori4=new Origine("Poitou");
  Produit pro1 = new Produit("La rosette du Chatoux","rosette",8,3.9,"https://i.imgur.com/jdBVYXM.jpg",ori1);
  Produit pro2 = new Produit("La saucisson fumé de Jacquie","fumé",6.5,3.9,"https://i.imgur.com/gjcaHLD.jpg",ori1);
  Produit pro3 = new Produit("Saucisson du Rhone-Alpe à la noisette","noisette",5.99,4.1,"https://i.imgur.com/RyohsMn.jpg",ori2);
  Produit pro4 = new Produit("Le jurassique","à cuire",6.1,2.8,"https://i.imgur.com/M4KXyNl.jpg",ori3);
  Produit pro5 = new Produit("Le genepi de Marie-Louise","aromatisé",7.15,4.8,"https://i.imgur.com/A8lUIHX.jpg",ori3);
  Produit pro6 = new Produit("Le saucisson maigre","maigre",7.15,4.8,"https://i.imgur.com/Oh8zlIt.jpg",ori4);
  servicepro.addProduit(pro1); 
  servicepro.addProduit(pro2); 
  servicepro.addProduit(pro3); 
  servicepro.addProduit(pro4); 
  servicepro.addProduit(pro5); 
  servicepro.addProduit(pro6); 
 
  //System.out.println(pro1.toString());
 }

}