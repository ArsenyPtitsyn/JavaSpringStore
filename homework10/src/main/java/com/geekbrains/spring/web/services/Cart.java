package com.geekbrains.spring.web.services;

import com.geekbrains.spring.web.dto.ProductDto;
import com.geekbrains.spring.web.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Cart {
    private List<ProductDto> productsInCart;

    @PostConstruct
    public void init() {
        productsInCart = new ArrayList<>();
    }

    public Cart showCart() {
        return this;
    }

    public Integer showPrice() {
        return productsInCart.stream().mapToInt(ProductDto::getPrice).sum();
    }

    public void addProductInCartById(ProductDto productDto) {
        productsInCart.add(productDto);
    }

    public void removeProductFromCartById(Long id) {
        productsInCart.remove(productsInCart.stream().filter(p -> p.getId().equals(id)).findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("No such product in cart. Id = " + id)));
    }

    public void clearCart() {
        productsInCart.clear();
    }
}
