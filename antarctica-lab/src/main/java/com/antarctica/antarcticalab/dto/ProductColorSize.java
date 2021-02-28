package com.antarctica.antarcticalab.dto;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@JsonAutoDetect
@NoArgsConstructor
public class ProductColorSize {
    private Product product;
    private Color color;
    private Size size;
    private Set<Price> prices;
    private int quantity;
    private String measures;

}
