package ru.geekbrains.spring.data.jpa.controllers;

import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.data.jpa.entities.Product;
import ru.geekbrains.spring.data.jpa.exceptions.ResourceNotFoundException;
import ru.geekbrains.spring.data.jpa.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> findAll(
            @RequestParam(name = "min_cost", defaultValue = "0") Integer minCost,
            @RequestParam(name = "max_cost", required = false) Integer maxCost
    ) {
        if (maxCost == null)
            maxCost = Integer.MAX_VALUE;
        return productService.findAllByPriceBetween(minCost, maxCost);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @PostMapping
    public Product insertNewProduct(@RequestBody Product newProduct) {
        return productService.save(newProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
