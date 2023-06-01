package ru.job4j.fast_food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.fast_food.domain.model.notification.GenericNotification;
import ru.job4j.fast_food.domain.model.order.Order;
import ru.job4j.fast_food.event.order.OrderCancelledEvent;
import ru.job4j.fast_food.event.order.OrderCreatedEvent;
import ru.job4j.fast_food.event.order.OrderUpdateEvent;

import static ru.job4j.fast_food.domain.model.notification.NotificationType.GENERIC_NOTIFICATION;

@RestController
@PropertySource("classpath:order.properties")
public class OrderNotificationController {

    @Value("${kafka.order-notification}")
    private String orderNotification;
    @Autowired
    private KafkaTemplate<Integer, GenericNotification> kafkaNotificationTemplate;

    @EventListener
    public void handleOrderCreatedEvent(OrderCreatedEvent event) {
        Order receivedOrder = event.getOrder();
        System.out.println("EVENT OrderCreatedEvent");
        kafkaNotificationTemplate.send(orderNotification, new GenericNotification(
                String.format("Your order (id: %s) has been placed", receivedOrder.getId()),
                GENERIC_NOTIFICATION));
    }

    @EventListener
    public void handleOrderUpdateEvent(OrderUpdateEvent event) {
        Order receivedOrder = event.getOrder();
        System.out.println("EVENT OrderUpdateEvent");
        kafkaNotificationTemplate.send(orderNotification, new GenericNotification(
                String.format("Your order (id: %s) has been updated. Statud: %s",
                        receivedOrder.getId(), receivedOrder.getJobStatus()),
                GENERIC_NOTIFICATION));
    }

    @EventListener
    public void handleOrderCancelledEvent(OrderCancelledEvent event) {
        Order receivedOrder = event.getOrder();
        System.out.println("EVENT OrderCancelledEvent");
        kafkaNotificationTemplate.send(orderNotification, new GenericNotification(
                String.format("Your order (id: %s) has been cancelled", receivedOrder.getId()),
                GENERIC_NOTIFICATION));
    }
}
