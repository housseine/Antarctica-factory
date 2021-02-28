package com.housseine.product.infra.bdd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.housseine.product.domain.IProductSpecDomainRepository;
import com.housseine.product.entity.ProductColorSize;

@Component
public class ProductSpecRepository implements IProductSpecDomainRepository{
	@Autowired
	IProductSpecRepository productSpecRepository;
	
	@Override
	public List<ProductColorSize> getAllProductSpecs() {
		return productSpecRepository.findAll();
	}

	@Override
	public ProductColorSize addProduct(ProductColorSize productLine) {
			return productSpecRepository.save(productLine);
	}

	@Override
	public void deleteProductSpec(ProductColorSize product) {
		productSpecRepository.delete(product);
		
	}

	@Override
	public ProductColorSize updateProductSpec(ProductColorSize productLine) {
		return productSpecRepository.saveAndFlush(productLine);
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

	@Override
	public List<ProductColorSize> getProductSpecByProductId(Long id) {
		return productSpecRepository.findByProductId(id);
	}

}
