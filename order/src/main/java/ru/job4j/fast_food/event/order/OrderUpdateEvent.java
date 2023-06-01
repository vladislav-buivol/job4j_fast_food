package ru.job4j.fast_food.event.order;

import ru.job4j.fast_food.domain.model.order.Order;

public class OrderUpdateEvent {
    private final Order order;

    public OrderUpdateEvent(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}
