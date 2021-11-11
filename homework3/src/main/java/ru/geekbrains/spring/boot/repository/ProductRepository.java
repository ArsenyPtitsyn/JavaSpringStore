package ru.geekbrains.spring.boot.repository;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring.boot.model.Product;

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
        products.add(new Product(1L, "bread", 40));
        products.add(new Product(2L, "milk", 70));
        products.add(new Product(3L, "apples", 200));
        products.add(new Product(4L, "pears", 150));
        products.add(new Product(5L, "peaches", 250));
        products.add(new Product(6L, "tea", 340));
        products.add(new Product(7L, "coffee", 500));
        products.add(new Product(8L, "sunflower oil", 90));
        products.add(new Product(9L, "olive oil", 300));
        products.add(new Product(10L, "potatoes", 20));
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    public Product findBiId(Long id) {
        return products.get(Math.toIntExact(id - 1));
    }
}
