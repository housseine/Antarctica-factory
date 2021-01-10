package com.housseine.clothes.infra.bdd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.housseine.clothes.domain.IClothesDomainRepository;
import com.housseine.clothes.entity.Clothes;
@Component
public class ClothesRepository implements IClothesDomainRepository {

	@Autowired
	IClothesRepository iClothesRepository;
	
	@Override
	public Clothes addClothes(Clothes clothes) {
		return iClothesRepository.saveAndFlush(clothes);
	}

	@Override
	public List<Clothes> getAllClothess() {
		return iClothesRepository.findAll();
	}

	@Override
	public void deleteClothes(Long clothesId) {
		iClothesRepository.deleteById(clothesId);
	}

	@Override
	public Clothes updateClothes(Clothes clothes) {
		return iClothesRepository.saveAndFlush(clothes);
	}

	@Override
	public Optional<Clothes> getClothesById(Long id) {
		return iClothesRepository.findById(id);
	}

	@Override
	public List<Clothes> getClothesByLabel(String term) {
		return iClothesRepository.findByLabelContainingIgnoreCase(term);
	}

}
