package com.housseine.clothes.service;

import java.util.List;
import java.util.Optional;

import com.housseine.clothes.entity.Clothes;
public interface IClothesService {
	Clothes addclothes(Clothes clothes);
	List<Clothes> getAllclothess();
	void deleteclothes(Long clothesId);
	void updateclothes(Clothes clothes);
	Optional<Clothes> getclothesById(Long id);
	List<Clothes> getClothesByLabel(String term);

}
