package com.housseine.clothes.resource;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
import com.housseine.clothes.entity.Clothes;
import com.housseine.clothes.service.IClothesService;
@WebMvcTest(controllers = ClothesController.class)
class ClothesControllerTest {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private IClothesService service;

	Clothes clothes;
	Set<Categorie> categories;

	@BeforeEach
	public void setup() {
		categories = new HashSet<Categorie>();
		categories.add(new Categorie("Men"));
		categories.add(new Categorie("Wemone"));
		categories.add(new Categorie("Kids"));
		clothes = new Clothes("Niollo", "Great Clothes", new Date(), categories);
		clothes.setId(1L);
	}

	@Test
	public void shouldGetAllClothess() throws Exception {

		List<Clothes> allClothess = Arrays.asList(clothes);

		when(service.getAllClothess()).thenReturn(allClothess);

		mvc.perform(get("/clothes/getall").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.length()", is(1))).andExpect(jsonPath("$[0].label", is(clothes.getLabel())));
	}

	@Test
	public void shouldAddClothes() throws Exception {

		when(service.addClothes(Mockito.any())).thenReturn(clothes);
		mvc.perform(post("/clothes").characterEncoding("UTF-8").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(clothes))).andExpect(status().isOk()).andExpect(jsonPath("$.length()", is(5)))
				.andExpect(jsonPath("$.label", is(clothes.getLabel())));
	}

	@Test
	public void shouldDeleteClothes() throws Exception {
		mvc.perform(delete("/clothes/{id}", "1").characterEncoding("UTF-8").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void shouldUpdateClothes() throws Exception {
		when(service.updateClothes(Mockito.any())).thenReturn(clothes);
		mvc.perform(patch("/clothes").characterEncoding("UTF-8").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(clothes))).andExpect(status().isOk()).andExpect(jsonPath("$.length()", is(5)))
				.andExpect(jsonPath("$.label", is(clothes.getLabel())));
	}

	@Test
	public void shouldGetClothesById() throws Exception {
		when(service.getClothesById(1L)).thenReturn(Optional.of(clothes));
		mvc.perform(get("/clothes/{id}", "1").characterEncoding("UTF-8").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.length()", is(5)))
				.andExpect(jsonPath("$.label", is(clothes.getLabel())));
	}

	@Test
	public void shouldGetClothesByLabel() throws Exception {
		when(service.getClothesByLabel("Kids")).thenReturn(Arrays.asList(clothes));
		mvc.perform(get("/clothes?term=Kids").characterEncoding("UTF-8").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.length()", is(1)))
				.andExpect(jsonPath("$[0].label", is(clothes.getLabel())));
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
