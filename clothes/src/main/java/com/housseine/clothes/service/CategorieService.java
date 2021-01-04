package com.housseine.clothes.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.housseine.clothes.domain.ICategorieDomainRepository;
import com.housseine.clothes.entity.Categorie;

@Service
public class CategorieService implements ICategorieService {
	@Autowired
	ICategorieDomainRepository categorieRepository;

	@Override
	public Categorie addCategorie(Categorie categorie) {
		return categorieRepository.addCategorie(categorie);
	}

	@Override
	public List<Categorie> getAllcategories() {
		return categorieRepository.getAllCategories();
	}

	@Override
	public void deleteCategorie(Long categorieId) {
		categorieRepository.deleteCategorie(categorieId);		
	}

	@Override
	public void updateCategorie(Categorie categorie) {
		categorieRepository.updateCategorie(categorie);		
	}

	@Override
	public Optional<Categorie> getCategorieById(Long id) {
		return categorieRepository.getCategorieById(id);
	}

	@Override
	public List<Categorie> getCategorieByLabel(String term) {
		return categorieRepository.getCategorieByLabel(term);
	}
}
