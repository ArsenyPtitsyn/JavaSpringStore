package ru.geekbrains.spring.data.jpa.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ru.geekbrains.spring.data.jpa.entities.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCostBetween(int minPrice, int maxPrice);
}
