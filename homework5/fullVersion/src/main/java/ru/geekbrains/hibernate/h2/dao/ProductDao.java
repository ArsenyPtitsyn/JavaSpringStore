package ru.geekbrains.hibernate.h2.dao;

import ru.geekbrains.hibernate.h2.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAllProducts();
    Product findProductById(Long id);
    Product saveOrUpdateProduct(Product product);
    void deleteProductById(Long id);
}
