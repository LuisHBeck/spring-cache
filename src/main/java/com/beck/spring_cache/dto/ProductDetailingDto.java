package com.beck.spring_cache.dto;

import com.beck.spring_cache.model.Product;

import java.io.Serializable;
import java.util.UUID;

public record ProductDetailingDto(
        UUID id,
        String name,
        String description
) implements Serializable {
    public ProductDetailingDto(Product product) {
        this(
                product.getId(),
                product.getName(),
                product.getDescription()
        );
    }
}
