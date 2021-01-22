package com.housseine.clothes.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "CLOTHES_TABLE")
public class Clothes {
	@Id
	@Column(name = "clothes_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String label;
	private String description;
	private Date date;
	
	@ManyToMany(cascade = { CascadeType.MERGE },fetch = FetchType.LAZY)
	@JoinTable(name = "CLOTHES_CATEGORIE", joinColumns = { @JoinColumn(name = "clothes_id") }, inverseJoinColumns = {
			@JoinColumn(name = "categorie_id") })
	Set<Categorie> categories = new HashSet<>();

	public Clothes(String label, String description, Date date, Set<Categorie> categories) {
		super();
		this.label = label;
		this.description = description;
		this.date = date;
		this.categories = categories;
	}

}
