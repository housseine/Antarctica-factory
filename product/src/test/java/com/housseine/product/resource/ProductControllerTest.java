package com.housseine.product.resource;

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
import com.housseine.product.entity.Categorie;
import com.housseine.product.entity.Product;
import com.housseine.product.resource.ProductController;
import com.housseine.product.service.IProductService;
@WebMvcTest(controllers = ProductController.class)
class ProductControllerTest {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private IProductService service;

	Product product;
	Set<Categorie> categories;

	@BeforeEach
	public void setup() {
		categories = new HashSet<Categorie>();
		categories.add(new Categorie("Men"));
		categories.add(new Categorie("Wemone"));
		categories.add(new Categorie("Kids"));
		product = new Product("Niollo", "Great Product", new Date(), categories,null,null,null);
		product.setId(1L);
	}

	@Test
	public void shouldGetAllProducts() throws Exception {

		List<Product> allProducts = Arrays.asList(product);

		when(service.getAllProducts()).thenReturn(allProducts);

		mvc.perform(get("/product/all").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.length()", is(1))).andExpect(jsonPath("$[0].label", is(product.getLabel())));
	}

	@Test
	public void shouldAddProduct() throws Exception {

		when(service.addProduct(Mockito.any())).thenReturn(product);
		mvc.perform(post("/product").characterEncoding("UTF-8").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(product))).andExpect(status().isOk()).andExpect(jsonPath("$.length()", is(5)))
				.andExpect(jsonPath("$.label", is(product.getLabel())));
	}

	@Test
	public void shouldDeleteProduct() throws Exception {
		mvc.perform(delete("/product/{id}", "1").characterEncoding("UTF-8").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void shouldUpdateProduct() throws Exception {
		when(service.updateProduct(Mockito.any())).thenReturn(product);
		mvc.perform(patch("/product").characterEncoding("UTF-8").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(product))).andExpect(status().isOk()).andExpect(jsonPath("$.length()", is(5)))
				.andExpect(jsonPath("$.label", is(product.getLabel())));
	}

	@Test
	public void shouldGetProductById() throws Exception {
		when(service.getProductById(1L)).thenReturn(Optional.of(product));
		mvc.perform(get("/product/{id}", "1").characterEncoding("UTF-8").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.length()", is(5)))
				.andExpect(jsonPath("$.label", is(product.getLabel())));
	}

	@Test
	public void shouldGetProductByLabel() throws Exception {
		when(service.getProductByLabel("Kids")).thenReturn(Arrays.asList(product));
		mvc.perform(get("/product?term=Kids").characterEncoding("UTF-8").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.length()", is(1)))
				.andExpect(jsonPath("$[0].label", is(product.getLabel())));
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
