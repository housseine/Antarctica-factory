package com.housseine.product.entity;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonAutoDetect
@Entity
@Table(name = "PRODUCT_TABLE")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String label;
    private String description;
    private Date date;

    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "PRODUCT_CATEGORIE", joinColumns = {@JoinColumn(name = "product_id")}, inverseJoinColumns = {
            @JoinColumn(name = "categorie_id")})
    private Set<Categorie> categories = new HashSet<>();

    private String link;
    private String majority;
    private String gender;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("Product")
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
