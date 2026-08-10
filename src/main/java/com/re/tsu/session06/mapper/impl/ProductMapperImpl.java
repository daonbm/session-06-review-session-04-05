package com.re.tsu.session06.mapper.impl;

import com.re.tsu.session06.dto.request.ProductCreateRequest;
import com.re.tsu.session06.dto.ProductDto;
import com.re.tsu.session06.dto.response.ProductCreateResponse;
import com.re.tsu.session06.dto.response.ProductImgUpdateResponse;
import com.re.tsu.session06.dto.response.ProductUpdateResponse;
import com.re.tsu.session06.entity.Category;
import com.re.tsu.session06.entity.Product;
import com.re.tsu.session06.mapper.ProductMapper;
import com.re.tsu.session06.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class ProductMapperImpl implements ProductMapper {
    private final CategoryRepository categoryRepository;

    @Override
    public ProductDto toDto(Product entity) {
        ProductDto dto = new ProductDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public List<ProductDto> toDtoList(List<Product> entities) {
        List<ProductDto> dtoList = new ArrayList<>();
        for (Product entity: entities) {
            ProductDto dto = toDto(entity);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public Product toEntity(ProductCreateRequest dto) {
        Product entity = new Product();
        BeanUtils.copyProperties(dto, entity);
        Category category = categoryRepository.findById(dto.getCategoryId()).orElse(null);
        entity.setCategory(category);
        return entity;
    }

    @Override
    public ProductCreateResponse toCreationDto(Product entity) {
        ProductCreateResponse dto = new ProductCreateResponse();
        BeanUtils.copyProperties(entity, dto);
        dto.setCategoryId(entity.getCategory().getId());
        return dto;
    }

    @Override
    public ProductImgUpdateResponse toUpdateImgDto(Product entity) {
        ProductImgUpdateResponse dto = new ProductImgUpdateResponse();
        BeanUtils.copyProperties(entity, dto);
        dto.setImgUrl(entity.getImgUrl());
        return dto;
    }

    @Override
    public ProductUpdateResponse toUpdateDto(Product entity) {
        ProductUpdateResponse dto = new ProductUpdateResponse();
        BeanUtils.copyProperties(entity, dto);
        dto.setImgUrl(entity.getImgUrl());
        return dto;
    }
}
