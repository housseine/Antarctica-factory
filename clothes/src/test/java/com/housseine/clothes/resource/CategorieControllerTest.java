package com.housseine.clothes.resource;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.housseine.clothes.entity.Categorie;
import com.housseine.clothes.service.ICategorieService;

@WebMvcTest(controllers = CategorieController.class)
class CategorieControllerTest {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private ICategorieService service;

	Categorie categorie;

	@BeforeEach
	public void setup() {
		categorie = new Categorie("Kids");
		categorie.setId(1L);
	}

	@Test
	public void shouldGetAllCategories() throws Exception {

		List<Categorie> allCategories = Arrays.asList(categorie);

		when(service.getAllcategories()).thenReturn(allCategories);

		mvc.perform(get("/categorie/getall").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.length()", is(1))).andExpect(jsonPath("$[0].label", is(categorie.getLabel())));
	}

	@Test
	public void shouldAddCategorie() throws Exception {

		when(service.addCategorie(Mockito.any())).thenReturn(categorie);
		mvc.perform(post("/categorie").characterEncoding("UTF-8").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(categorie))).andExpect(status().isOk()).andExpect(jsonPath("$.length()", is(2)))
				.andExpect(jsonPath("$.label", is(categorie.getLabel())));
	}

	@Test
	public void shouldDeleteCategorie() throws Exception {
		mvc.perform(delete("/categorie/{id}", "1").characterEncoding("UTF-8").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void shouldUpdateCategorie() throws Exception {
		when(service.updateCategorie(Mockito.any())).thenReturn(categorie);
		mvc.perform(patch("/categorie").characterEncoding("UTF-8").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(categorie))).andExpect(status().isOk()).andExpect(jsonPath("$.length()", is(2)))
				.andExpect(jsonPath("$.label", is(categorie.getLabel())));
	}
	
	//TODO ADD TESTS FOR getByCategorieById and ByLabel

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
