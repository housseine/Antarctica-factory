package com.antarctica.antarcticalab.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Currency {
    private Long id;
    private String Label;

    public Currency(String label) {
        super();
        Label = label;
    }
}
