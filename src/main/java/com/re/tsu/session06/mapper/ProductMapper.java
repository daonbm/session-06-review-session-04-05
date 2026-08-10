package com.re.tsu.session06.mapper;

import com.re.tsu.session06.dto.request.ProductCreateRequest;
import com.re.tsu.session06.dto.ProductDto;
import com.re.tsu.session06.dto.response.ProductCreateResponse;
import com.re.tsu.session06.dto.response.ProductImgUpdateResponse;
import com.re.tsu.session06.dto.response.ProductUpdateResponse;
import com.re.tsu.session06.entity.Product;

import java.util.List;

public interface ProductMapper {
    ProductDto toDto(Product entity);
    List<ProductDto> toDtoList(List<Product> entities);
    Product toEntity(ProductCreateRequest dto);
    ProductCreateResponse toCreationDto(Product entity);
    ProductImgUpdateResponse toUpdateImgDto(Product entity);
    ProductUpdateResponse toUpdateDto(Product entity);
}
