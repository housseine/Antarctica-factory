package com.housseine.clothes.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonAutoDetect
@Entity
@Table(name = "CATEGORIE_TABLE")
public class Categorie {
	@Id
	@Column(name = "categorie_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String label;
	@JsonIgnore
	@ManyToMany(mappedBy = "categories",fetch = FetchType.LAZY)
	private Set<Clothes> clothes = new HashSet<>();

	public Categorie(String label, Set<Clothes> clothes) {
		super();
		this.label = label;
		this.clothes = clothes;
	}
	
	public Categorie(String label) {
		super();
		this.label = label;
	}

}
