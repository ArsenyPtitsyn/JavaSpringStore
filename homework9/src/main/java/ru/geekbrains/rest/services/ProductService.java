package ru.geekbrains.rest.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.geekbrains.rest.entities.Product;
import ru.geekbrains.rest.repositories.ProductRepository;
import ru.geekbrains.rest.repositories.specifications.ProductSpecifications;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Page<Product> find(Integer minCost, Integer maxCost, String titlePart, Integer page) {
        Specification<Product> specification = Specification.where(null);
        if (minCost != null) {
            specification = specification.and(ProductSpecifications.costGreaterThanOrEqualsTo(minCost));
        }
        if (maxCost != null) {
            specification = specification.and(ProductSpecifications.costLessThanOrEqualsTo(maxCost));
        }
        if (titlePart != null) {
            specification = specification.and(ProductSpecifications.titleLike(titlePart));
        }

        return productRepository.findAll(specification, PageRequest.of(page - 1, 5));
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
