package com.geekbrains.spring.web.controllers;

import com.geekbrains.spring.web.converters.ProductConverter;
import com.geekbrains.spring.web.dto.ProductDto;
import com.geekbrains.spring.web.exceptions.ResourceNotFoundException;
import com.geekbrains.spring.web.services.Cart;
import com.geekbrains.spring.web.services.ProductsService;
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
    private final ProductsService productsService;
    private final ProductConverter productConverter;

    @GetMapping
    public Cart getCart() {
        return cart.showCart();
    }

    @GetMapping("/add/{id}")
    public Cart addProductInCartById(@PathVariable Long id) {
        ProductDto productDto = productConverter.entityToDto(productsService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id)));
        cart.addProductInCartById(productDto);
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

    @GetMapping("/show_price")
    public Integer showPrice() {
        return cart.showPrice();
    }
}
