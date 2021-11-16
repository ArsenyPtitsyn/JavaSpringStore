package com.geekbrains.spring.boot.controllers;

import com.geekbrains.spring.boot.model.Product;
import com.geekbrains.spring.boot.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.findProductById(id);
    }

    @GetMapping("/change_cost")
    public void changeCost(@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changeCost(productId, delta);
    }

    @GetMapping("/delete/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
    }
}
