package ru.geekbrains.spring.context;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Scope(scopeName = "prototype")
@RequiredArgsConstructor
public class Cart {
    private final ProductRepository productRepository;

    private List<Product> productsInCart;

    public void addProductInCartById(Long id) {
        productsInCart.add(productRepository.getProductById(id - 1));
    }

    public void deleteProductFromCartById(Long id) {
        productsInCart.remove(productRepository.getProductById(id - 1));
    }

    public List<Product> showProductsInCart() {
        return Collections.unmodifiableList(productsInCart);
    }

    @PostConstruct
    public void init() {
        productsInCart = new ArrayList<>();
    }
}
