package com.geekbrains.app;

import lombok.Data;

@Data
public class Product {
    private Integer id;
    private String title;
    private Integer cost;

    public Product(Integer id, String title, Integer cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("[id: %d, title: %s, cost: %d]", id, title, cost);
    }
}
