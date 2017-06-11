package org.descartes.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.descartes.domain.Client;
import org.descartes.domain.Personne;
import org.descartes.domain.Produit;
import org.descartes.services.IServiceClient;
import org.descartes.services.IServicePersonne;
import org.descartes.services.ServiceClient;
import org.descartes.services.ServiceOrigine;
import org.descartes.services.ServicePersonne;
import org.descartes.services.ServiceProduit;
import org.descartes.services.ServiceSearch;
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
	ServiceOrigine serviceOrigine = new ServiceOrigine();
	ServiceSearch serviceSearch = new ServiceSearch();

	@RequestMapping(value = "/client", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<?> getClient(){
		return serviceClient.findAll();
	}
	
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Produit getProduit(@PathVariable("id") long id){
		return serviceProduit.findProduit(id);
	}
	
	@RequestMapping(value = "/subscription/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public boolean setSubscription(@RequestBody List<String> tab){
		System.out.println(tab.get(1));
		 serviceClient.Abonnement(tab.get(0),tab.get(1));
		 return true;
	}
	
	@RequestMapping(value = "/produit", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<?> getallProduct(){
		return serviceProduit.findAll();
	}

	@RequestMapping(value = "/inscription", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void postClient(@RequestBody List<String> tab){
		serviceClient.addClient(tab.get(0),tab.get(1),tab.get(2), tab.get(3), tab.get(4));
	}
	
	@RequestMapping(value = "/authentification", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public boolean login(HttpServletRequest request,@RequestBody List<String> tab){
		System.out.println(tab.get(0));
		return serviceClient.login(tab.get(0),tab.get(1));
	}
	
	@RequestMapping(value = "/origine", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<?> getAllOrigins(){
		return serviceOrigine.findAll();
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<?> getSearch(@PathVariable("search") String search){
		return serviceSearch.findAll(search);
	}
}
