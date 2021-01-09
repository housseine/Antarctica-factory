package com.housseine.clothes.service;

import java.util.List;
import java.util.Optional;

import com.housseine.clothes.entity.Clothes;
public interface IClothesService {
	Clothes addClothes(Clothes clothes);
	List<Clothes> getAllClothess();
	void deleteClothes(Long clothesId);
	void updateClothes(Clothes clothes);
	Optional<Clothes> getClothesById(Long id);
	List<Clothes> getClothesByLabel(String term);

}
