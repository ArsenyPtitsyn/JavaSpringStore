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
    private Long maxId;

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
        this.maxId = 10L;
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    public Product findProductById(Long id) {
        return products.get(Math.toIntExact(id - 1));
    }

    public Product saveOrUpdate(Product product) {
        if (product.getId() == null) {
            maxId++;
            product.setId(maxId);
            products.add(product);
            return product;
        } else {
            for (int i = 0; i < products.size(); i++) {
                if (product.getId().equals(products.get(i).getId())) {
                    products.set(i, product);
                    return product;
                }
            }
        }
        throw new RuntimeException("Something went wrong!");
    }

//    public void deleteById(Long id) {
//        products.removeIf(p -> p.getId().equals(id));
//    } // не понятно как после удаления нескольких (одного) товаров (товара), редактировать товары.
//      // Список уменьшается, а мы вытаскиваем товар по id не пробегая по списку...Короче БД надо прикручивать
}