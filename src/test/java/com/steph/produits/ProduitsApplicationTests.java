package com.steph.produits;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.steph.produits.entities.Categorie;
import com.steph.produits.entities.Produit;
import com.steph.produits.repos.ProduitRepository;
import com.steph.produits.service.ProduitService;

@SpringBootTest
class ProduitsApplicationTests {
	@Autowired
	ProduitService produitService;
    
	@Autowired
	ProduitRepository produitRepository;
    
	@Test
	public void testFindByNomProduitContains(){ 
		//                         (numero de la page, nbre d'objet dans une page)
		Page<Produit> prods =produitService.getAllProduitsParPage(0, 2);
		System.out.println(prods.getSize());
		System.out.println(prods.getTotalElements());
		System.out.println(prods.getTotalPages());
		prods.getContent().forEach(p -> {System.out.println(p.toString());
		});
		
	}
	
	@Test
	public void testFindProduitByNom() {
		List <Produit> p = produitRepository.findByNomProduit("Nokia N40");
		p.forEach(e -> {
			System.out.println("Find By Nom "+p);
		});
	}
	
	@Test
	public void testFindProduitByNomContains() {
		List <Produit> p = produitRepository.findByNomProduitContains("u");
		p.forEach(e -> {
			System.out.println("Find By u : "+p);
		});
	}
	
	@Test
	public void TestFindByNomPrix() {
		List <Produit> p = produitRepository.findByNomPrix("Nokia N40",200.09);
		
		Categorie c = new Categorie("Multimedia", "descr1", p);
		
		p.forEach(e -> {
			e.setCategorie(c);
			System.out.println("Find By Nokia N40 and 500 >  : "+e);
		});
	}
	
	@Test
	public void testfindByCategorie() {
		Categorie cat = new Categorie();
		cat.setIdCat(1L);
		
		produitRepository.findByCategorie(cat).forEach(c -> System.out.println("\t"+c));
	}
	
	@Test
	public void findByCategorieIdCat(){
		List<Produit> prods = produitRepository.findByCategorieIdCat(1L);
		 prods.forEach(p -> System.out.println(p));
	}
	
	@Test
	public void testfindByOrderByNomProduitAsc(){
		List<Produit> prods = produitRepository.findByOrderByNomProduitAsc();
		prods.forEach(p -> System.out.println(p));
	}
		
}
