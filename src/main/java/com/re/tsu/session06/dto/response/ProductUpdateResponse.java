package com.re.tsu.session06.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ProductUpdateResponse {
    private Long id;
    private Integer categoryId;
    private String name;
    private String description;
    private String link;
    private String imgUrl;
    private Double price;
    private Integer qty;
}
