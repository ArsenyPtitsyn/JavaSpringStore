package ru.geekbrains.hibernate.h2;

import java.util.List;

public interface ProductDao {
    Product findProductById(Long id);
    List<Product> findAllProducts();
    void deleteProductById(Long id);
    Product saveOrUpdate(Product product);
}
