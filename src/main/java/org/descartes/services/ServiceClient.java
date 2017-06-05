package org.descartes.services;

import java.util.List;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.descartes.domain.Client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;



public class ServiceClient implements IServiceClient{
	EntityManager entityManager;
	
	public ServiceClient() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		entityManager = emf.createEntityManager();
	}
	
	public Client findClient(String nom){
		List<Client> liste = entityManager.createQuery( "SELECT p FROM Client p WHERE p.nom LIKE :namePerson" )
				.setParameter( "namePerson", nom)
				.getResultList();
		return (Client) liste.get(0);
	}
	
	public List<?> findAll(){
		List liste = entityManager.createQuery( "SELECT p FROM Client p" )
				.getResultList();
		return liste;
	}
	
	public void addClient(String nom,String prenom,String adresse,String login, String password){
		
		System.out.println();
		String abonnement = "aucun";
		Client client = new Client(nom,prenom,adresse, login, password,abonnement);
		
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		
		    //do something with your database
			entityManager.persist(client);
		    tx.commit();
		    entityManager.close();
		
		
	}
	
	public boolean login(String login, String password){
		List<Client> liste = entityManager.createQuery( "SELECT p FROM Client p WHERE p.login LIKE :namePerson" )
				.setParameter( "namePerson", login)
				.getResultList();
		Client cli =liste.get(0);
		return password.equals(cli.getPassword());
	}
}

/*try{

ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");
QueueConnectionFactory factory = (QueueConnectionFactory) applicationContext.getBean("connectionFactory");

Queue queue = (Queue) applicationContext.getBean("queue");
// connection au message broker
QueueConnection connection = factory.createQueueConnection();
// ouvrir session sans transaction (1 seul message) et acquitement automatique
QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
connection.start();
// cr�er et envoyer message
TextMessage message = session.createTextMessage("bonjour");
QueueSender sender = session.createSender(queue);
sender.send(message);

session.close();
connection.close();

}catch(Exception e){
e.printStackTrace();
}*/
