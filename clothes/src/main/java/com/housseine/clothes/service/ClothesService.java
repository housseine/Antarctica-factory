package com.housseine.clothes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.housseine.clothes.domain.IClothesDomainRepository;
import com.housseine.clothes.entity.Clothes;
@Service
public class ClothesService implements IClothesService{
	@Autowired
	IClothesDomainRepository clothesRepository;

	@Override
	public Clothes addclothes(Clothes clothes) {
		return clothesRepository.addClothes(clothes);
	}

	@Override
	public List<Clothes> getAllclothess() {
		return clothesRepository.getAllClothess();
	}

	@Override
	public void deleteclothes(Long clothesId) {
		clothesRepository.deleteClothes(clothesId);		
	}

	@Override
	public void updateclothes(Clothes clothes) {
		clothesRepository.updateClothes(clothes);		
	}

	@Override
	public Optional<Clothes> getclothesById(Long id) {
		return clothesRepository.getClothesById(id);
	}

	@Override
	public List<Clothes> getClothesByLabel(String term) {
		return clothesRepository.getClothesByLabel(term);
	}

}
