package com.re.tsu.session06.service;

import com.re.tsu.session06.dto.request.ProductCreateRequest;
import com.re.tsu.session06.dto.ProductDto;
import com.re.tsu.session06.dto.response.ProductCreateResponse;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAll();
    ProductDto getById(Long id);
    ProductCreateResponse createProduct(ProductCreateRequest dto);
}
