package ru.job4j.fast_food.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import ru.job4j.fast_food.domain.model.order.Order;
import ru.job4j.fast_food.event.order.OrderCancelledEvent;
import ru.job4j.fast_food.event.order.OrderCreatedEvent;
import ru.job4j.fast_food.event.order.OrderUpdateEvent;

@Component
public class OrderEventPublisher {
    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public OrderEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publishOrderCreatedEvent(Order order) {
        OrderCreatedEvent event = new OrderCreatedEvent(order);
        eventPublisher.publishEvent(event);
    }

    public void publishOrderCancelledEvent(Order order) {
        OrderCancelledEvent event = new OrderCancelledEvent(order);
        eventPublisher.publishEvent(event);
    }

    public void publishOrderUpdatedEvent(Order order) {
        OrderUpdateEvent event = new OrderUpdateEvent(order);
        eventPublisher.publishEvent(event);
    }
}
