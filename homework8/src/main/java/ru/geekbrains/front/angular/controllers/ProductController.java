package ru.geekbrains.front.angular.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.front.angular.entities.Product;
import ru.geekbrains.front.angular.exceptions.ResourceNotFoundException;
import ru.geekbrains.front.angular.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProductsByCostBetween(
            @RequestParam(name = "min_cost", defaultValue = "0") Integer minCost,
            @RequestParam(name = "max_cost", required = false) Integer maxCost) {
        if (maxCost == null)
            maxCost = Integer.MAX_VALUE;
        return productService.findAllByCostBetween(minCost, maxCost);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @PostMapping
    public Product saveNewProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }
}
