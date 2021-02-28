package com.housseine.product.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@IdClass(ProductColorSizeId.class)
@Getter
@Setter
@JsonAutoDetect
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT_COLOR_SIZE")
public class ProductColorSize {
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	@JsonIgnoreProperties("productColorSizes")
	private Product product;

	@Id
	@ManyToOne(cascade = CascadeType.ALL )
	@JoinColumn(name = "color_id")
	private Color color;

	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "size_id")
	private Size size;

	@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name = "price_id")
	private Set<Price> prices;
	private int quantity;
	private String measures;

}
