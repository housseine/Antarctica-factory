package com.housseine.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "COLOR_TABLE")
public class Color {
	@Id
	@Column(name = "color_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String value;

}
