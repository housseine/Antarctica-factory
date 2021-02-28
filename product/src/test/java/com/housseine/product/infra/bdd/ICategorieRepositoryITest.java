package com.housseine.product.infra.bdd;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.housseine.product.TestConfig;
import com.housseine.product.entity.Categorie;
import com.housseine.product.infra.bdd.ICategorieRepository;

@ContextConfiguration(classes = TestConfig.class)
@EnableJpaRepositories(basePackages = { "com.housseine.*" })
@EntityScan("com.housseine.clothes.entity")

@RunWith(SpringRunner.class)
@DataJpaTest
class ICategorieRepositoryITest {

	@Autowired
	private ICategorieRepository iCategorieRepository;
	Categorie categorie;
	List<Categorie> found;

	@Before
	public void before() {

	}

	@Test
	public void whenFindByLabelContainingIgnoreCase_thenReturnEmployee() {

		// given
		categorie = new Categorie("women");
		iCategorieRepository.save(categorie);

		// when
		found = iCategorieRepository.findByLabelContainingIgnoreCase(categorie.getLabel());

		// then
		assertThat(found.get(0).getLabel()).isEqualTo(categorie.getLabel());

	}

	@Test
	public void whenUpdateCategorie_thenShouldFindIt() {
		// given
		categorie = new Categorie("women");
		iCategorieRepository.save(categorie);
		Categorie categorie2 = iCategorieRepository.findByLabelContainingIgnoreCase(categorie.getLabel()).get(0);
		categorie2.setLabel("PullOver");
		iCategorieRepository.save(categorie2);

		// when
		found = iCategorieRepository.findByLabelContainingIgnoreCase(categorie2.getLabel());

		// then
		assertThat(found.get(0).getLabel()).isEqualTo(categorie2.getLabel());
	}

	@Test
	public void whenDeleteCategorie_thenShouldNotFindIt() {
		// given
		categorie = new Categorie("women");
		iCategorieRepository.save(categorie);
		iCategorieRepository.delete(categorie);
		// when
		found = iCategorieRepository.findByLabelContainingIgnoreCase(categorie.getLabel());

		// then
		assertTrue(found.size() == 0);
		;
	}

	@Test
	public void shouldGetCategorieById() {
		// given
		categorie = new Categorie("women");
		iCategorieRepository.save(categorie);
		found = iCategorieRepository.findByLabelContainingIgnoreCase(categorie.getLabel());
		Long id = found.get(0).getId();

		// when
		Optional<Categorie> categorieOptional = iCategorieRepository.findById(id);
		Categorie categorie2 = categorieOptional.get();
		// then
		assertEquals(categorie, categorie2);
		;
	}

	@Test
	public void shouldGetAll() {
		categorie = new Categorie("women");
		iCategorieRepository.save(categorie);
		iCategorieRepository.save(new Categorie("men"));
		iCategorieRepository.save(new Categorie("Kids"));
		found = iCategorieRepository.findAll();
		assertEquals(3, found.size());
	}
}
