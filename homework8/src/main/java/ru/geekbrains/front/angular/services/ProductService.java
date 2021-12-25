package ru.geekbrains.front.angular.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.geekbrains.front.angular.entities.Product;
import ru.geekbrains.front.angular.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Page<Product> findAll(int page) {
        return productRepository.findAll(PageRequest.of(page -1, 10));
    }

    public Page<Product> findAllByCostBetween(int minCost, int maxCost, int page) {
        return productRepository.findAllByCostBetween(minCost, maxCost, PageRequest.of(page - 1, 10));
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
