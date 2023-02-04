package ru.job4j.fast_food.domain.model.dish;

import lombok.Data;
import ru.job4j.fast_food.domain.model.order.Product;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Dish implements Product {
    private int id;
    private BigDecimal price;
    private String description;
    private List<Ingredients> components;
}
