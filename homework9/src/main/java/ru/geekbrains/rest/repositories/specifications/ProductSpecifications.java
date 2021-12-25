package ru.geekbrains.rest.repositories.specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.geekbrains.rest.entities.Product;

public class ProductSpecifications {
    public static Specification<Product> costGreaterThanOrEqualsTo(Integer cost) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("cost"), cost);
    }

    public static Specification<Product> costLessThanOrEqualsTo(Integer cost) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("cost"), cost);
    }

    public static Specification<Product> titleLike(String titlePart) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
                .like(root.get("title"), String.format("%%%s%%", titlePart));
    }
}