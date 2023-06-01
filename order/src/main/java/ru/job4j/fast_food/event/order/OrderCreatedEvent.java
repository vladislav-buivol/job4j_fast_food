package ru.job4j.fast_food.event.order;

import ru.job4j.fast_food.domain.model.order.Order;

public class OrderCreatedEvent {
    private final Order order;

    public OrderCreatedEvent(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}
