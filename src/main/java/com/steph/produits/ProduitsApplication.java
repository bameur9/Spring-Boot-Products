package com.steph.produits;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.steph.produits.entities.Produit;
import com.steph.produits.service.ProduitService;

@SpringBootApplication
public class ProduitsApplication //implements CommandLineRunner 
{
    @Autowired
	ProduitService produitService;
    //@Autowired
    //private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(ProduitsApplication.class, args);
	}
 /*
	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Produit.class);
		
	}
	
	*/

}
