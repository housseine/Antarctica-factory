package com.housseine.product.service;

import java.util.List;
import java.util.Optional;

import com.housseine.product.entity.Product;

public interface IProductService {

	Product addProduct(Product clothes);

	List<Product> getAllProducts();

	void deleteProduct(Long productId);

	Product updateProduct(Product product);

	Optional<Product> getProductById(Long id);

	List<Product> getProductByLabel(String term);

}
