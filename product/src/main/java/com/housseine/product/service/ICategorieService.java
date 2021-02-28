package com.housseine.product.service;

import java.util.List;
import java.util.Optional;

import com.housseine.product.entity.Categorie;

public interface ICategorieService {

	Categorie addCategorie(Categorie categorie);

	List<Categorie> getAllcategories();

	void deleteCategorie(Long categorieId);

	Categorie updateCategorie(Categorie categorie);

	Optional<Categorie> getCategorieById(Long id);

	List<Categorie> getCategorieByLabel(String term);
}
