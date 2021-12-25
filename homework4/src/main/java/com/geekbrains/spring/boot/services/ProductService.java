package com.geekbrains.spring.boot.services;

import com.geekbrains.spring.boot.model.Product;
import com.geekbrains.spring.boot.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAllProducts();
    }

    public Product findProductById(Long id) {
        return productRepository.findProductById(id);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteProductById(id);
    }

    public void changeCost(Long id, Integer delta) {
        Product product = productRepository.findProductById(id);
        product.setCost(product.getCost() + delta);
    }
}
