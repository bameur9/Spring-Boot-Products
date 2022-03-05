package com.steph.produits.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.steph.produits.entities.Categorie;
import com.steph.produits.entities.Produit;

@RepositoryRestResource(path = "rest")
public interface ProduitRepository extends JpaRepository<Produit, Long> {

	List<Produit> findByNomProduit(String nom);
	List<Produit> findByNomProduitContains(String nom);


	@Query("SELECT p FROM Produit p WHERE p.nomProduit LIKE %:nom AND p.prixProduit > :prix")
	List<Produit> findByNomPrix(@Param("nom") String nom, @Param("prix") Double prix);
	
	@Query("SELECT p FROM Produit p WHERE p.categorie = :cat")
	List<Produit> findByCategorie (@Param("cat") Categorie cat);
	
	List<Produit> findByCategorieIdCat(long id);
	
	List<Produit> findByOrderByNomProduitAsc();
	
	@Query("select p from Produit p order by p.nomProduit ASC, p.prixProduit DESC")
	List<Produit> trierProduitsNomsPrix ();

}
