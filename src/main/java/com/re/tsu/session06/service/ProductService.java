package com.re.tsu.session06.service;

import com.re.tsu.session06.dto.request.ProductCreateRequest;
import com.re.tsu.session06.dto.ProductDto;
import com.re.tsu.session06.dto.request.ProductImgUpdateRequest;
import com.re.tsu.session06.dto.request.ProductUpdateRequest;
import com.re.tsu.session06.dto.response.ProductCreateResponse;
import com.re.tsu.session06.dto.response.ProductImgUpdateResponse;
import com.re.tsu.session06.dto.response.ProductUpdateResponse;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAll();
    ProductDto getById(Long id);
    ProductCreateResponse createProduct(ProductCreateRequest dto);
    ProductImgUpdateResponse updateProductImg(Long id, ProductImgUpdateRequest dto);
    ProductUpdateResponse updateProduct(Long id, ProductUpdateRequest dto);
    Boolean deleteProduct(Long id);
}
