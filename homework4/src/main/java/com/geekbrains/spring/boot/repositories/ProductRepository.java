package com.geekbrains.spring.boot.repositories;

import com.geekbrains.spring.boot.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1L, "bread", 35));
        products.add(new Product(2L, "milk", 90));
        products.add(new Product(3L, "vine", 570));
    }

    public List<Product> findAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product findProductById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().get();
    }

    public void deleteProductById(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }
}