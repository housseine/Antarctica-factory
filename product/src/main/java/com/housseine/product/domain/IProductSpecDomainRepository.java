package com.housseine.product.domain;

import java.util.List;
import java.util.Optional;

import com.housseine.product.entity.ProductColorSize;

public interface IProductSpecDomainRepository {
	List<ProductColorSize> getAllProductSpecs();

	ProductColorSize addProduct(ProductColorSize productLine);

	void deleteProductSpec(ProductColorSize productId);

	ProductColorSize updateProductSpec(ProductColorSize productLine);

	Optional<ProductColorSize> getProductSpecById(Long id);

	List<ProductColorSize> getProductSpecByProductLabel(String term);

    List<ProductColorSize> getProductSpecByProductId(Long id);
}
