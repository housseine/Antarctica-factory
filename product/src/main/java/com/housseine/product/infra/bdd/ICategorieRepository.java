package com.housseine.product.infra.bdd;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.housseine.product.entity.Categorie;

@Repository
public interface ICategorieRepository  extends JpaRepository<Categorie, Long>{
	List<Categorie> findByLabelContainingIgnoreCase(String term);
}
