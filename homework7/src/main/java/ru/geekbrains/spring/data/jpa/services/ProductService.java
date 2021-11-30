package ru.geekbrains.spring.data.jpa.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.spring.data.jpa.entities.Product;
import ru.geekbrains.spring.data.jpa.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllByPriceBetween(int minCost, int maxCost) {
        return productRepository.findAllByCostBetween(minCost, maxCost);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
