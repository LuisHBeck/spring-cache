package com.beck.spring_cache.controller;

import com.beck.spring_cache.dto.ProductDetailingDto;
import com.beck.spring_cache.dto.ProductRequestDto;
import com.beck.spring_cache.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDetailingDto> createProduct(
            @RequestBody @Valid ProductRequestDto productRequestDto
    ) {
        ProductDetailingDto productResponseDto = productService.createProduct(productRequestDto);
        return ResponseEntity.ok(productResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailingDto> getProductById(@PathVariable UUID id) {
        ProductDetailingDto productResponseDto = productService.getProductById(id);
        return ResponseEntity.ok(productResponseDto);
    }
}
