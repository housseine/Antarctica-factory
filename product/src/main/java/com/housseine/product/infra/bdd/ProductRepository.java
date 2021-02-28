package com.housseine.product.infra.bdd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.housseine.product.domain.IProductDomainRepository;
import com.housseine.product.entity.Product;
@Component
public class ProductRepository implements IProductDomainRepository {

	@Autowired
	IProductRepository iProductRepository;
	
	@Override
	public Product addProduct(Product product) {
		return iProductRepository.saveAndFlush(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return iProductRepository.findAll();
	}

	@Override
	public void deleteProduct(Long productId) {
		iProductRepository.deleteById(productId);
	}

	@Override
	public Product updateProduct(Product product) {
		return iProductRepository.saveAndFlush(product);
	}

	@Override
	public Optional<Product> getProductById(Long id) {
		return iProductRepository.findById(id);
	}

	@Override
	public List<Product> getProductByLabel(String term) {
		return iProductRepository.findByLabelContainingIgnoreCase(term);
	}

}
