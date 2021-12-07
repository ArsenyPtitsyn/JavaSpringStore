package ru.geekbrains.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.rest.dto.ProductDto;
import ru.geekbrains.rest.entities.Product;
import ru.geekbrains.rest.exceptions.ResourceNotFoundException;
import ru.geekbrains.rest.services.ProductService;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public Page<ProductDto> getAllProducts (
            @RequestParam(name = "min_cost", required = false) Integer minCost,
            @RequestParam(name = "max_cost", required = false) Integer maxCost,
            @RequestParam(name = "title_part", required = false) String titlePart,
            @RequestParam(name = "p", defaultValue = "1") Integer page
    ) {
        if (page < 1)
            page = 1;
        return productService.find(minCost, maxCost, titlePart, page).map(ProductDto::new);
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return productService.findById(id).map(ProductDto::new)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
    }

    @PostMapping
    public Product saveNewProduct(@RequestBody ProductDto productDto) {
        Product product = new Product(null, productDto.getTitle(), productDto.getCost());
        return productService.save(product);
    }


    @PutMapping
    public Product updateProduct(@RequestBody ProductDto productDto) {
        Product product = new Product(productDto.getId(), productDto.getTitle(), productDto.getCost());
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
