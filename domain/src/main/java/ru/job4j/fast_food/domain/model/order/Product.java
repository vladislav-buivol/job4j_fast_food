package ru.job4j.fast_food.domain.model.order;

import java.math.BigDecimal;

public interface Product {
    int getId();

    BigDecimal getPrice();
}
