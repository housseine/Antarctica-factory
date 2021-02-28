package com.housseine.product.service;

import java.util.List;
import java.util.Optional;

import com.housseine.product.entity.ProductColorSize;

public interface IProductSpecService {

	List<ProductColorSize> getAllProductSpecs();

	ProductColorSize addProductSpec(ProductColorSize productLine);

	void deleteProductSpec(ProductColorSize productId);

	ProductColorSize updateProductSpec(ProductColorSize productLine);

	Optional<ProductColorSize> getProductSpecById(Long id);

	List<ProductColorSize> getProductSpecByProductLabel(String term);

}
