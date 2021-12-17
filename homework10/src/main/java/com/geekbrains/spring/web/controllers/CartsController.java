package com.geekbrains.spring.web.controllers;

import com.geekbrains.spring.web.services.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/carts")
@RequiredArgsConstructor
public class CartsController {
    private final Cart cart;

    @GetMapping
    public Cart getCart() {
        return cart.showCart();
    }

    @GetMapping("/add/{id}")
    public Cart addProductInCartById(@PathVariable Long id) {
        cart.addProductInCartById(id);
        return cart.showCart();
    }

    @GetMapping("/remove/{id}")
    public Cart removeProductFromCartById(Long id) {
        cart.removeProductFromCartById(id);
        return cart.showCart();
    }

    @GetMapping("/clear")
    public void clearCart() {
        cart.clearCart();
    }
}
