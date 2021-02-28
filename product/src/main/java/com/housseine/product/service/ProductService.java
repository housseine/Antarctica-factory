package com.housseine.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.housseine.product.domain.IProductDomainRepository;
import com.housseine.product.entity.Product;
@Service
public class ProductService implements IProductService{
	@Autowired
	IProductDomainRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		return productRepository.addProduct(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	@Override
	public void deleteProduct(Long productId) {
		productRepository.deleteProduct(productId);		
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepository.updateProduct(product);		
	}

	@Override
	public Optional<Product> getProductById(Long id) {
		return productRepository.getProductById(id);
	}

	@Override
	public List<Product> getProductByLabel(String term) {
		return productRepository.getProductByLabel(term);
	}

}
