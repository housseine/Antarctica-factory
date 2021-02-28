package com.housseine.product.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductColorSizeId implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long product;

	private Long color;

	private Long size;
}
