package com.housseine.product.domain;

import java.util.List;
import java.util.Optional;

import com.housseine.product.entity.Categorie;

public interface ICategorieDomainRepository {
	Categorie addCategorie(Categorie categorie);

	List<Categorie> getAllCategories();

	void deleteCategorie(Long categorieId);

	Categorie updateCategorie(Categorie categorie);

	Optional<Categorie> getCategorieById(Long id);

	List<Categorie> getCategorieByLabel(String termToSearch);
}
