package com.housseine.product.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.housseine.product.entity.Product;
import com.housseine.product.service.IProductService;

@RestController()
@RequestMapping("/product")
public class ProductController {
	@Autowired
	IProductService productService;

	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProduct() {
		return new ResponseEntity<List<Product>>(productService.getAllProducts(), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.addProduct(product), HttpStatus.OK);
	}

	@PatchMapping()
	public ResponseEntity<Product> updateproduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.updateProduct(product), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	void deleteproduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Product>> getProductById(@PathVariable Long id) {
		return new ResponseEntity<Optional<Product>>(productService.getProductById(id), HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<List<Product>> getProductByName(@RequestParam("term") String term) {
		return new ResponseEntity<List<Product>>(productService.getProductByLabel(term), HttpStatus.OK);
	}
}
