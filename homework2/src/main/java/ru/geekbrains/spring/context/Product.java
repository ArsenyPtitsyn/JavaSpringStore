package ru.geekbrains.spring.context;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    private String title;
    private int cost;

    @Override
    public String toString() {
        return String.format("[%d, %s, %d]", id, title, cost);
    }
}
