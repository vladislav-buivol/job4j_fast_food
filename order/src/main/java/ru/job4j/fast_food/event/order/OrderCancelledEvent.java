package ru.job4j.fast_food.event.order;

import ru.job4j.fast_food.domain.model.order.Order;

public class OrderCancelledEvent {
    private final Order order;

    public OrderCancelledEvent(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}
