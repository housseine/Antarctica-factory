package com.housseine.product.domain;

import java.util.List;
import java.util.Optional;

import com.housseine.product.entity.Product;

public interface IProductDomainRepository {
	Product addProduct(Product product);

	List<Product> getAllProducts();

	void deleteProduct(Long productId);

	Product updateProduct(Product product);

	Optional<Product> getProductById(Long id);

	List<Product> getProductByLabel(String term);

}
