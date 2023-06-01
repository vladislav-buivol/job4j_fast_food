package ru.job4j.fast_food.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.job4j.fast_food.domain.model.order.Order;
import ru.job4j.fast_food.service.OrderServiceFastFood;

@Component
public class PreorderKafkaListener {
    private final OrderServiceFastFood orderService;

    public PreorderKafkaListener(OrderServiceFastFood orderService) {
        this.orderService = orderService;
    }

    @KafkaListener(topics = {"${kafka.preorder-order}"})
    public void preorderListener(ConsumerRecord<Integer, Order> input) {
        System.out.println("Message received from kitchen: " + input);
        Order order = orderService.save(input.value());
        orderService.publishEvent(order);
    }
}
