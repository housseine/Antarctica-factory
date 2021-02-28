package com.housseine.product.service;

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

import com.housseine.product.domain.IProductDomainRepository;
import com.housseine.product.entity.Categorie;
import com.housseine.product.entity.Product;
import com.housseine.product.infra.bdd.IProductRepository;
import com.housseine.product.service.IProductService;
import com.housseine.product.service.ProductService;

@RunWith(MockitoJUnitRunner.class)
class IProductServiceTest {

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@InjectMocks
	IProductService productService = new ProductService();

	@Mock
	IProductRepository productRepository;

	@Mock
	IProductDomainRepository productDomainRepository;

	Product product;
	Set<Categorie> categories;

	@BeforeEach
	public void setup() {
		categories = new HashSet<Categorie>();
		categories.add(new Categorie("Men"));
		categories.add(new Categorie("Wemone"));
		categories.add(new Categorie("Kids"));
		product = new Product("Niollo", "Great Product", new Date(), categories,null,null,null);
	}

	@Test
	public void shouldAddProduct() {
		// Given
		when(productDomainRepository.addProduct(product)).thenReturn(product);
		// when
		Product product2 = productService.addProduct(product);
		Product product3 = new Product(product2.getLabel(), product2.getDescription(), product2.getDate(),
				product2.getCategories(),null,null,null);

		// then
		assertThat(product).isEqualToComparingFieldByField(product3);
	}

	@Test
	public void shouldUpdateProduct() {
		// when
		product.setLabel("New Labem");
		productService.updateProduct(product);

		// then
		verify(productDomainRepository, times(1)).updateProduct(product);
	}

	@Test
	public void shouldDeleteProduct() {
		// when
		productService.deleteProduct(1L);
		// then
		verify(productDomainRepository, times(1)).deleteProduct(1L);
	}

	@Test
	public void shouldGetAllProducts() {
		// given
		List<Product> products = new ArrayList<Product>();
		products.add(product);
		products.add(product);
		when(productDomainRepository.getAllProducts()).thenReturn(products);
		// when
		List<Product> products2 = productService.getAllProducts();
		// then
		assertThat(products).isEqualTo(products2);
		verify(productDomainRepository, times(1)).getAllProducts();
	}

	@Test
	public void shouldProductById() {
		// given
		Optional<Product> optionalProductOptional = Optional.of(product);
		when(productDomainRepository.getProductById(1L)).thenReturn(optionalProductOptional);
		// when
		Optional<Product> optionalProductOptional2 = productService.getProductById(1L);
		// then
		assertThat(optionalProductOptional.get()).isEqualToComparingFieldByField(optionalProductOptional2.get());
		verify(productDomainRepository, times(1)).getProductById(1L);
	}

	@Test
	public void shouldGetProductByTerm() {
		// given
		List<Product> products = new ArrayList<Product>();
		products.add(product);
		when(productDomainRepository.getProductByLabel("Niollo")).thenReturn(products);
		// when
		List<Product> products2 = productService.getProductByLabel("Niollo");
		// then
		assertThat(products).isEqualTo(products2);
		verify(productDomainRepository, times(1)).getProductByLabel("Niollo");
	}

}
