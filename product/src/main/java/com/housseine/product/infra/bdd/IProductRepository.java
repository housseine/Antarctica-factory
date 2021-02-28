package com.housseine.product.infra.bdd;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.housseine.product.entity.Product;
@Repository
public interface IProductRepository  extends JpaRepository<Product, Long>{
	List<Product> findByLabelContainingIgnoreCase(String term);
}
