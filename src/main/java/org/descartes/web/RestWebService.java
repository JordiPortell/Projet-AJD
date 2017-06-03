package org.descartes.web;

import java.util.List;

import org.descartes.domain.Client;
import org.descartes.domain.Personne;
import org.descartes.domain.Produit;
import org.descartes.services.IServiceClient;
import org.descartes.services.IServicePersonne;
import org.descartes.services.ServiceClient;
import org.descartes.services.ServicePersonne;
import org.descartes.services.ServiceProduit;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@EnableAutoConfiguration 
public class RestWebService {
	
	IServiceClient serviceClient = new ServiceClient();
	ServiceProduit serviceProduit = new ServiceProduit();

	@RequestMapping(value = "/client", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<?> getClient(){
		return serviceClient.findAll();
	}
	
	
	@RequestMapping(value = "/produit/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Produit getProduit(@PathVariable("id") long id){
		return serviceProduit.findProduit(id);
	}
	
	@RequestMapping(value = "/produit", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<?> getallProduct(){
		return serviceProduit.findAll();
	}
	

	
	@RequestMapping(value = "/inscription", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void postClient(@RequestBody String Nom,String Prenom,String adresse,String login, String password){
		serviceClient.addClient(Nom,Prenom,adresse,login,password);
	}
	
	@RequestMapping(value = "/authentification", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void login(@RequestBody String login,String password){
		System.out.println(login);
		serviceClient.login(login,password);
	}
	
}
