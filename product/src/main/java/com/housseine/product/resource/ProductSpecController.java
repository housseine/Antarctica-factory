package com.housseine.product.resource;

import java.util.List;
import java.util.Optional;

import com.housseine.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

import com.housseine.product.entity.ProductColorSize;
import com.housseine.product.service.IProductSpecService;

@RestController()
@RequestMapping("/product-spec")
public class ProductSpecController {

    @Autowired
    private IProductSpecService productSpecService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductColorSize>> getAllProductSpecs() {
        return new ResponseEntity<List<ProductColorSize>>(productSpecService.getAllProductSpecs(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ProductColorSize> addProductSpec(@RequestBody ProductColorSize productLine) {

        try {
            return new ResponseEntity<ProductColorSize>(productSpecService.addProductSpec(productLine), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PatchMapping()
    public ResponseEntity<ProductColorSize> updateProductSpec(@RequestBody ProductColorSize productLine) {
        return new ResponseEntity<ProductColorSize>(productSpecService.updateProductSpec(productLine), HttpStatus.OK);
    }

    @DeleteMapping()
    void deleteproduct(@RequestBody ProductColorSize productLine) {
        productSpecService.deleteProductSpec(productLine);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProductColorSize>> getProductSpecById(@PathVariable Long id) {
        return new ResponseEntity<Optional<ProductColorSize>>(productSpecService.getProductSpecById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ProductColorSize>> getProductSpecByName(@RequestParam("term") String term) {
        return new ResponseEntity<List<ProductColorSize>>(productSpecService.getProductSpecByProductLabel(term), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<List<ProductColorSize>> getProductSpecByProductId(@PathVariable Long id) {
		return  new ResponseEntity<List<ProductColorSize>>(productSpecService.getProductSpecByProductId(id),HttpStatus.OK);
    }
}
