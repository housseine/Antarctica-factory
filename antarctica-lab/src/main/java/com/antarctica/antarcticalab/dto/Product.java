package com.antarctica.antarcticalab.dto;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@JsonAutoDetect
public class Product {
    private Long id;
    private String label;
    private String description;
    private Date date;


    private Set<Categorie> categories = new HashSet<>();

    private String link;
    private String majority;
    private String gender;

    private Set<ProductColorSize> productColorSizes = new HashSet<>();

    public Product(String label, String description, Date date, Set<Categorie> categories, String link, String majority,
                   String gender) {
        super();
        this.label = label;
        this.description = description;
        this.date = date;
        this.categories = categories;
        this.link = link;
        this.majority = majority;
        this.gender = gender;
    }

}
