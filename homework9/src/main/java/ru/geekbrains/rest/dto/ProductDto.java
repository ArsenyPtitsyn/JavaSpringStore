package ru.geekbrains.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.rest.entities.Product;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String title;
    private Integer cost;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.cost = product.getCost();
    }
}
