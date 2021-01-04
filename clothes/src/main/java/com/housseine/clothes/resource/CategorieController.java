package com.housseine.clothes.resource;


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

import com.housseine.clothes.entity.Categorie;
import com.housseine.clothes.service.CategorieService;


@RestController()
@RequestMapping("/categorie")
public class CategorieController {
	@Autowired
	CategorieService categorieService;

	@GetMapping("/getall")
	public ResponseEntity<List<Categorie>> getAllCategorie() {
		return new ResponseEntity<List<Categorie>>(categorieService.getAllcategories(), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Categorie> addCategorie(@RequestBody Categorie categorie) {
		return new ResponseEntity<Categorie>(categorieService.addCategorie(categorie), HttpStatus.OK);
	}

	@PatchMapping()
	public void updatecategorie(@RequestBody Categorie categorie) {
		categorieService.updateCategorie(categorie);
	}

	@DeleteMapping("/{id}")
	void deletecategorie(@PathVariable Long id) {
		categorieService.deleteCategorie(id);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Categorie>> getCategorieById(@PathVariable Long id) {
		return new ResponseEntity<Optional<Categorie>>(categorieService.getCategorieById(id), HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<List<Categorie>> getCategorieByName(@RequestParam("term") String term) {
		return new ResponseEntity<List<Categorie>>(categorieService.getCategorieByLabel(term), HttpStatus.OK);
	}
}
