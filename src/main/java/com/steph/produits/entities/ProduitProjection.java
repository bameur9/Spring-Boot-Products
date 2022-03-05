package com.steph.produits.entities;

import org.springframework.data.rest.core.config.Projection;

/**
 * L'objectif des projections est de limiter le resultat JSON retourné a un certain nombre
 * d'attributs. Par exemple on peut avoir besoin seulement de l'attribut nomProduit:
 * 
 * @author steph
 */
@Projection(name= "nomProd", types = {Produit.class})
public interface ProduitProjection {
	public String getNomProduit();

}
