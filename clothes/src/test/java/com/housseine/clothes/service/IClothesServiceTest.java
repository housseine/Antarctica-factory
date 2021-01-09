package com.housseine.clothes.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.housseine.clothes.domain.IClothesDomainRepository;
import com.housseine.clothes.entity.Categorie;
import com.housseine.clothes.entity.Clothes;
import com.housseine.clothes.infra.bdd.IClothesRepository;

@RunWith(MockitoJUnitRunner.class)
class IClothesServiceTest {

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@InjectMocks
	IClothesService clothesService = new ClothesService();

	@Mock
	IClothesRepository clothesRepository;

	@Mock
	IClothesDomainRepository clothesDomainRepository;

	Clothes clothes;
	Set<Categorie> categories;

	@BeforeEach
	public void setup() {
		categories = new HashSet<Categorie>();
		categories.add(new Categorie("Men"));
		categories.add(new Categorie("Wemone"));
		categories.add(new Categorie("Kids"));
		clothes = new Clothes("Niollo", "Great Clothes", new Date(), categories);
	}

	@Test
	public void shouldAddClothes() {
		// Given
		when(clothesDomainRepository.addClothes(clothes)).thenReturn(clothes);
		// when
		Clothes clothes2 = clothesService.addClothes(clothes);
		Clothes clothes3 = new Clothes(clothes2.getLabel(), clothes2.getDescription(), clothes2.getDate(),
				clothes2.getCategories());

		// then
		assertThat(clothes).isEqualToComparingFieldByField(clothes3);
	}

	@Test
	public void shouldUpdateClothes() {
		// when
		clothes.setLabel("New Labem");
		clothesService.updateClothes(clothes);

		// then
		verify(clothesDomainRepository, times(1)).updateClothes(clothes);
	}

	@Test
	public void shouldDeleteClothes() {
		// when
		clothesService.deleteClothes(1L);
		// then
		verify(clothesDomainRepository, times(1)).deleteClothes(1L);
	}

	@Test
	public void shouldGetAllClothess() {
		// given
		List<Clothes> clothess = new ArrayList<Clothes>();
		clothess.add(clothes);
		clothess.add(clothes);
		when(clothesDomainRepository.getAllClothess()).thenReturn(clothess);
		// when
		List<Clothes> clothess2 = clothesService.getAllclothess();
		// then
		assertThat(clothess).isEqualTo(clothess2);
		verify(clothesDomainRepository, times(1)).getAllClothess();
	}

	@Test
	public void shouldClothesById() {
		// given
		Optional<Clothes> optionalClothesOptional = Optional.of(clothes);
		when(clothesDomainRepository.getClothesById(1L)).thenReturn(optionalClothesOptional);
		// when
		Optional<Clothes> optionalClothesOptional2 = clothesService.getClothesById(1L);
		// then
		assertThat(optionalClothesOptional.get()).isEqualToComparingFieldByField(optionalClothesOptional2.get());
		verify(clothesDomainRepository, times(1)).getClothesById(1L);
	}

	@Test
	public void shouldGetClothesByTerm() {
		// given
		List<Clothes> clothess = new ArrayList<Clothes>();
		clothess.add(clothes);
		when(clothesDomainRepository.getClothesByLabel("Niollo")).thenReturn(clothess);
		// when
		List<Clothes> clothess2 = clothesService.getClothesByLabel("Niollo");
		// then
		assertThat(clothess).isEqualTo(clothess2);
		verify(clothesDomainRepository, times(1)).getClothesByLabel("Niollo");
	}

}
