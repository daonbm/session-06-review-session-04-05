package com.re.tsu.session06.controller;

import com.re.tsu.session06.dto.request.ProductCreateRequest;
import com.re.tsu.session06.dto.ProductDto;
import com.re.tsu.session06.dto.response.ProductCreateResponse;
import com.re.tsu.session06.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> retrieveProducts() {
        List<ProductDto> productDtos = productService.getAll();
        return ResponseEntity.ok(productDtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> retrieveProduct(@PathVariable Long id) {
        ProductDto productDto = productService.getById(id);
        return ResponseEntity.ok(productDto);
    }

    @PostMapping
    public ResponseEntity<ProductCreateResponse> addProduct(@RequestBody ProductCreateRequest dto) {
        ProductCreateResponse newDto = productService.createProduct(dto);
        URI location = URI.create("/api/v1/products/" + newDto.getId());
        return ResponseEntity.created(location).body(newDto); // HATEOAS
    }
}
