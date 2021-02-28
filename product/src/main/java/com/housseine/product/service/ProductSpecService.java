package com.housseine.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.housseine.product.domain.IProductSpecDomainRepository;
import com.housseine.product.entity.ProductColorSize;

@Service
public class ProductSpecService implements IProductSpecService {
	
	@Autowired
	private IProductSpecDomainRepository productSpecRepository;

	@Override
	public List<ProductColorSize> getAllProductSpecs() {
		return productSpecRepository.getAllProductSpecs();
	}

	@Override
	public ProductColorSize addProductSpec(ProductColorSize productLine) {
		return productSpecRepository.addProduct(productLine);
	}

	@Override
	public void deleteProductSpec(ProductColorSize productId) {
		productSpecRepository.deleteProductSpec(productId);

	}

	@Override
	public ProductColorSize updateProductSpec(ProductColorSize productLine) {
		return productSpecRepository.updateProductSpec(productLine);
	}

	@Override
	public Optional<ProductColorSize> getProductSpecById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductColorSize> getProductSpecByProductLabel(String term) {
		// TODO Auto-generated method stub
		return null;
	}

}
