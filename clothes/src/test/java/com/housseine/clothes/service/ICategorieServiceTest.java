package com.housseine.clothes.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	Categorie categorie;

	@BeforeEach
	public void setup() {
		categorie = new Categorie("Kids");
	}

	@Test
	public void shouldAddCategorie() {
		// Given
		when(categorieDomainRepository.addCategorie(categorie)).thenReturn(categorie);
		// when
		Categorie categorie2 = categorieService.addCategorie(categorie);
		Categorie categorie3 = new Categorie(categorie2.getLabel());

		// then
		assertThat(categorie).isEqualToComparingFieldByField(categorie3);
	}

	@Test
	public void shouldUpdateCategorie() {
		// when
		categorie.setLabel("New Labem");
		categorieService.updateCategorie(categorie);

		// then
		verify(categorieDomainRepository, times(1)).updateCategorie(categorie);
	}

	@Test
	public void shouldDeleteCategorie() {
		// when
		categorieService.deleteCategorie(1L);
		// then
		verify(categorieDomainRepository, times(1)).deleteCategorie(1L);
	}

	@Test
	public void shouldGetAllCategories() {
		// given
		List<Categorie> categories = new ArrayList<Categorie>();
		categories.add(new Categorie("kids"));
		categories.add(new Categorie("Men"));
		categories.add(new Categorie("Women"));
		when(categorieDomainRepository.getAllCategories()).thenReturn(categories);
		// when
		List<Categorie> categories2 = categorieService.getAllcategories();
		// then
		assertThat(categories).isEqualTo(categories2);
		verify(categorieDomainRepository, times(1)).getAllCategories();
	}

}
