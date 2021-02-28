package com.housseine.product.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRICE_TABLE")
public class Price {
	@Id
	@Column(name = "price_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private float value;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "currency_id", referencedColumnName = "currency_id")
	private Currency currency;

}
