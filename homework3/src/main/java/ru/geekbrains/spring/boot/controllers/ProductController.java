package ru.geekbrains.spring.boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.spring.boot.model.Product;
import ru.geekbrains.spring.boot.repository.ProductRepository;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductRepository productRepository;

    @Autowired
    public void setProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public String showAllProducts(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "all_products";
    }

    @GetMapping("/{id}")
    public String showOneProductById(Model model, @PathVariable Long id) {
        Product product = productRepository.findBiId(id);
        model.addAttribute("product", product);
        return "product_info";
    }
}
