package ru.geekbrains.spring.boot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.boot.model.Product;
import ru.geekbrains.spring.boot.repository.ProductRepository;

import java.util.List;

@Component
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product findProductById(Long id) {
        return productRepository.findProductById(id);
    }

    public Product saveOrUpdateProduct(Product product) {
        return productRepository.saveOrUpdate(product);
    }

//    public void deleteProductById(Long id) {
//        productRepository.deleteById(id);
//    }
}
