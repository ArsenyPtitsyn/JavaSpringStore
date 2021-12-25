package ru.geekbrains.hibernate.h2.controllers;

import org.springframework.web.bind.annotation.*;
import ru.geekbrains.hibernate.h2.model.Product;
import ru.geekbrains.hibernate.h2.services.ProductService;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteProductById(id);
    }

    @GetMapping("/products/change_cost")
    public void changeScore(@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changeCost(productId, delta);
    }
}
