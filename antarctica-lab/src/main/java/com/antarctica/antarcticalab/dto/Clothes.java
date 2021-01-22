package com.antarctica.antarcticalab.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Clothes {
	
	private Long id;
	private String label;
	private String description;
	private Date date;
	
	
	Set<Categorie> categories = new HashSet<>();

	public Clothes(String label, String description, Date date, Set<Categorie> categories) {
		super();
		this.label = label;
		this.description = description;
		this.date = date;
		this.categories = categories;
	}
}
