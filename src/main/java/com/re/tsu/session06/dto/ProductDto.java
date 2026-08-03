package com.re.tsu.session06.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ProductDto {
    private Long id;
    private String name;
    private Double price;
    private Integer qty;
}
