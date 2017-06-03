package org.descartes;

import org.descartes.domain.Client;
import org.descartes.domain.Commande;
import org.descartes.domain.Personne;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestBody;
import org.descartes.services.ServiceClient;
import org.descartes.services.ServicePersonne;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjetAjdApplicationTests {

	@Test
	public void contextLoads() {
		/*ServicePersonne Service= new ServicePersonne();
		ServiceClient servicecli = new ServiceClient();
		Personne Thibault = new Personne();
		 Client cli1 = new Client("Dupont","Christophe","7 rue de la mairie");
		Thibault.setNom("thibault");
		Service.addPersonne(Thibault);
		servicecli.addClient(cli1);
		cli1= servicecli.findClient("Dupont");
		System.out.println(cli1.toString());*/
		ServiceClient servicecli = new ServiceClient();
		Client cli1 = new Client("Dupont","Christophe","7 rue de la mairie");
		Commande c1 = new Commande(cli1);
		servicecli.addClient(cli1); 
		cli1.addCommande(c1);
		cli1.getListCommande();
		System.out.println(cli1.toString());
	}

}