package ru.geekbrains.front.angular.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.front.angular.entities.Product;
import ru.geekbrains.front.angular.exceptions.ResourceNotFoundException;
import ru.geekbrains.front.angular.services.ProductService;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public Page<Product> getAllProductsByCostBetween(
            @RequestParam(name = "min_cost", defaultValue = "0") Integer minCost,
            @RequestParam(name = "max_cost", required = false) Integer maxCost,
            @RequestParam(name = "p", defaultValue = "1") Integer page) {
        if (maxCost == null)
            maxCost = Integer.MAX_VALUE;
        if (page < 1)
            page = 1;
        return productService.findAllByCostBetween(minCost, maxCost, page);
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
