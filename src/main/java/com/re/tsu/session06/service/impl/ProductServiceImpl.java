package com.re.tsu.session06.service.impl;

import com.re.tsu.session06.dto.request.ProductCreateRequest;
import com.re.tsu.session06.dto.ProductDto;
import com.re.tsu.session06.dto.response.ProductCreateResponse;
import com.re.tsu.session06.entity.Product;
import com.re.tsu.session06.mapper.ProductMapper;
import com.re.tsu.session06.repository.ProductRepository;
import com.re.tsu.session06.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> getAll() {
        List<Product> products = productRepository.findAll();
        return productMapper.toDtoList(products);
    }

    @Override
    public ProductDto getById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return productMapper.toDto(product);
    }

    @Override
    public ProductCreateResponse createProduct(ProductCreateRequest dto) {
        Product product = productMapper.toEntity(dto);
        Product newProduct = productRepository.save(product);
        return productMapper.toCreationDto(newProduct);
    }
}
