package ru.job4j.fast_food.domain.model.order;

import lombok.Data;

import java.util.Map;

@Data
public class Cart {
    private int id;
    private int orderId;
    private Map<Product, Quantity> products;

}
