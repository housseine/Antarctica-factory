package com.housseine.clothes.domain;

import java.util.List;
import java.util.Optional;

import com.housseine.clothes.entity.Clothes;

public interface IClothesDomainRepository {
	Clothes addClothes(Clothes clothes);
	List<Clothes> getAllClothess();
	void deleteClothes(Long clothesId);
	Clothes updateClothes(Clothes clothes);
	Optional<Clothes> getClothesById(Long id);
	List<Clothes> getClothesByLabel(String term);

}
