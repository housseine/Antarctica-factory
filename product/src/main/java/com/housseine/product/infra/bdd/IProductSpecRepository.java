package com.housseine.product.infra.bdd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.housseine.product.entity.ProductColorSize;
import com.housseine.product.entity.ProductColorSizeId;
import java.util.List;

@Repository
public interface IProductSpecRepository extends JpaRepository<ProductColorSize, ProductColorSizeId>{
    List<ProductColorSize> findByProductId(Long id);
}
