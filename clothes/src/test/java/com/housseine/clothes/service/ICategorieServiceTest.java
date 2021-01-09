package com.housseine.clothes.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.housseine.clothes.domain.ICategorieDomainRepository;
import com.housseine.clothes.entity.Categorie;
import com.housseine.clothes.infra.bdd.ICategorieRepository;

@RunWith(MockitoJUnitRunner.class)
class ICategorieServiceTest {

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@InjectMocks
	ICategorieService categorieService = new CategorieService();

	@Mock
	ICategorieRepository categorieRepository;

	@Mock
	ICategorieDomainRepository categorieDomainRepository;

	@Test
	public void shouldAddCategorie() {
		// Given
		Categorie categorie = new Categorie("Kids");
		when(categorieDomainRepository.addCategorie(categorie)).thenReturn(categorie);
		// when
		Categorie categorie2 = categorieService.addCategorie(categorie);
		Categorie categorie3 = new Categorie(categorie2.getLabel());

		// then
		assertThat(categorie).isEqualToComparingFieldByField(categorie3);
	}
}
