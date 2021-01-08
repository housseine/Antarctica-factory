package com.housseine.clothes.infra.bdd;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.housseine.clothes.entity.Categorie;
import com.housseine.clothes.entity.Clothes;

@ContextConfiguration(classes = TestConfig.class)
@EnableJpaRepositories(basePackages = { "com.housseine.*" })
@EntityScan("com.housseine.clothes.entity")

@RunWith(SpringRunner.class)
@DataJpaTest
class IClothesRepositoryITest {

	@Autowired
	private IClothesRepository iClothesRepository;
	Clothes clothes;
	List<Clothes> found;
	Set<Categorie> categories;

	@BeforeEach
	public void before() {
		categories = new HashSet<Categorie>();
		categories.add(new Categorie("Men"));
		categories.add(new Categorie("Wemone"));
		categories.add(new Categorie("Kids"));
		clothes = new Clothes("Niollo", "Great Clothes", new Date(), categories);
	}

	@Test
	public void whenFindByLabelContainingIgnoreCase_thenReturnEmployee() {

		// given

		iClothesRepository.save(clothes);

		// when
		found = iClothesRepository.findByLabelContainingIgnoreCase(clothes.getLabel());

		// then
		assertThat(found.get(0).getLabel()).isEqualTo(clothes.getLabel());

	}

	@Test
	public void whenUpdateClothes_thenShouldFindIt() {
		// given
		iClothesRepository.save(clothes);
		Clothes clothes2 = iClothesRepository.findByLabelContainingIgnoreCase(clothes.getLabel()).get(0);
		clothes2.setLabel("PullOver");
		iClothesRepository.save(clothes2);

		// when
		found = iClothesRepository.findByLabelContainingIgnoreCase(clothes2.getLabel());

		// then
		assertThat(found.get(0).getLabel()).isEqualTo(clothes2.getLabel());
	}

	@Test
	public void whenDeleteClothes_thenShouldNotFindIt() {
		// given
		iClothesRepository.save(clothes);
		iClothesRepository.delete(clothes);
		// when
		found = iClothesRepository.findByLabelContainingIgnoreCase(clothes.getLabel());

		// then
		assertTrue(found.size() == 0);
		;
	}

	@Test
	public void shouldGetClothesById() {
		// given
		iClothesRepository.save(clothes);
		found = iClothesRepository.findByLabelContainingIgnoreCase(clothes.getLabel());
		Long id = found.get(0).getId();

		// when
		Optional<Clothes> clothesOptional = iClothesRepository.findById(id);
		Clothes clothes2 = clothesOptional.get();
		// then
		assertEquals(clothes, clothes2);
		;
	}

	@Test
	public void shouldGetAll() {
		iClothesRepository.save(clothes);
		found = iClothesRepository.findAll();
		assertEquals(1, found.size());
	}
}
