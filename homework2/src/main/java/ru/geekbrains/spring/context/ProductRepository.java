package ru.geekbrains.spring.context;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product getProductById(Long id) {
        return products.get(Math.toIntExact(id));
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1L, "Milk", 100));
        products.add(new Product(2L, "Bread", 50));
        products.add(new Product(3L, "Butter", 150));
        products.add(new Product(4L, "Apple", 300));
        products.add(new Product(5L, "Peach", 400));
    }
}
