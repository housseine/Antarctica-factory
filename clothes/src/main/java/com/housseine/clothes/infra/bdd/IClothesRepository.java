package com.housseine.clothes.infra.bdd;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.housseine.clothes.entity.Clothes;
@Repository
public interface IClothesRepository  extends JpaRepository<Clothes, Long>{
	List<Clothes> findByLabelContainingIgnoreCase(String term);
}
