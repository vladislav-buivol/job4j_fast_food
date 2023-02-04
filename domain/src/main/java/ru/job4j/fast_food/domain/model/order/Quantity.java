package ru.job4j.fast_food.domain.model.order;

import java.math.BigDecimal;

public class Quantity {
    private BigDecimal value;
    private Metric metric;

    public Quantity(BigDecimal value, Metric metric) {
        this.value = value;
        this.metric = metric;
    }

    public enum Metric {
        AMOUNT,
        WEIGHT

    }
}
