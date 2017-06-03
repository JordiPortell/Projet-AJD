package org.descartes;

import org.descartes.services.IServiceClient;
import org.descartes.services.ServiceClient;
import org.descartes.services.IServicePersonne;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationMarketPlace {
	


@Bean
public IServiceClient ServiceClient(){
		return new ServiceClient(); 
	}
	
	
}
