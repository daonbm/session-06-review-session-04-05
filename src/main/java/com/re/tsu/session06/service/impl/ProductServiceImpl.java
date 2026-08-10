package com.re.tsu.session06.service.impl;

import com.re.tsu.session06.dto.request.ProductCreateRequest;
import com.re.tsu.session06.dto.ProductDto;
import com.re.tsu.session06.dto.request.ProductImgUpdateRequest;
import com.re.tsu.session06.dto.request.ProductUpdateRequest;
import com.re.tsu.session06.dto.response.ProductCreateResponse;
import com.re.tsu.session06.dto.response.ProductImgUpdateResponse;
import com.re.tsu.session06.dto.response.ProductUpdateResponse;
import com.re.tsu.session06.entity.Product;
import com.re.tsu.session06.mapper.ProductMapper;
import com.re.tsu.session06.repository.ProductRepository;
import com.re.tsu.session06.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public ProductImgUpdateResponse updateProductImg(Long id, ProductImgUpdateRequest dto) {
        Optional<Product> currentProduct = productRepository.findById(id);
        currentProduct.ifPresent(product -> product.setImgUrl(dto.getImgUrl()));
        Product existProduct = currentProduct.orElse(null);
        assert existProduct != null;
        existProduct.setImgUrl(dto.getImgUrl());
        Product updatedProduct = productRepository.save(existProduct);
        return productMapper.toUpdateImgDto(updatedProduct);
    }

    @Override
    public ProductUpdateResponse updateProduct(Long id, ProductUpdateRequest dto) {
        Optional<Product> currentProduct = productRepository.findById(id);
        currentProduct.ifPresent(product -> BeanUtils.copyProperties(dto, product));
        Product existProduct = currentProduct.orElse(null);
        assert existProduct != null;
        Product updatedProduct = productRepository.save(existProduct);
        return productMapper.toUpdateDto(updatedProduct);
    }

    @Override
    public Boolean deleteProduct(Long id) {
        Optional<Product> deletedProduct = productRepository.findById(id);
        if (deletedProduct.isPresent()) {
            productRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
