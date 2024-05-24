package com.beck.spring_cache.service;

import com.beck.spring_cache.model.Product;
import org.springframework.cache.annotation.Cacheable;

import java.util.HashMap;
import java.util.Map;

public class ProductService {
    Map<Long, Product> products = new HashMap<>() {
        {
            put(1L, new Product(1L, "Notebook", "Macbook Pro"));
            put(2L, new Product(2L, "Notebook", "XPS"));
            put(3L, new Product(3L, "Notebook", "Alienware"));
            put(4L, new Product(4L, "Notebook", "Thinkpad"));
            put(5L, new Product(5L, "Notebook", "Zenbook"));
        }
    };

    @Cacheable("products")
    public Product getById(Long id) {
        System.out.println(String.format("Searching product with id %s", id));
        simulateLatency();
        return products.get(id);
    }

    private void simulateLatency() {
        try {
            Thread.sleep(1000L);
        }catch (InterruptedException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
