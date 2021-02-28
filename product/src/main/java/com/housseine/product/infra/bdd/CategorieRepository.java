package com.housseine.product.infra.bdd;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.housseine.product.domain.ICategorieDomainRepository;
import com.housseine.product.entity.Categorie;

@Component
public class CategorieRepository implements ICategorieDomainRepository {

	@Autowired
	ICategorieRepository iCategorieRepository;
	
	@Override
	public Categorie addCategorie(Categorie categorie) {
		return iCategorieRepository.saveAndFlush(categorie);
	}

	@Override
	public List<Categorie> getAllCategories() {
		return iCategorieRepository.findAll();
	}

	@Override
	public void deleteCategorie(Long categorieId) {
		iCategorieRepository.deleteById(categorieId);
	}

	@Override
	public Categorie updateCategorie(Categorie categorie) {
		return iCategorieRepository.saveAndFlush(categorie);
	}

	@Override
	public Optional<Categorie> getCategorieById(Long id) {
		return iCategorieRepository.findById(id);
	}

	@Override
	public List<Categorie> getCategorieByLabel(String term) {
		return iCategorieRepository.findByLabelContainingIgnoreCase(term);
	}

}
