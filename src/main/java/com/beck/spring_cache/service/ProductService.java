package com.beck.spring_cache.service;

import com.beck.spring_cache.dto.ProductDetailingDto;
import com.beck.spring_cache.dto.ProductRequestDto;
import com.beck.spring_cache.model.Product;
import com.beck.spring_cache.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductDetailingDto createProduct(ProductRequestDto productDto) {
        Product product = Product.builder()
                .name(productDto.name())
                .description(productDto.description())
                .build();

        productRepository.save(product);
        System.out.println("created");
        return new ProductDetailingDto(product);
    }

    @Cacheable("products")
    public ProductDetailingDto getProductById(UUID productId) {
        Product product = productRepository.getReferenceById(productId);
        System.out.println("GET FROM REPOSITORY");
        return new ProductDetailingDto(product);
    }
}
