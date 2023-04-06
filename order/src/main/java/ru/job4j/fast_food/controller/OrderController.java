package ru.job4j.fast_food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import ru.job4j.fast_food.domain.model.notification.GenericNotification;
import ru.job4j.fast_food.domain.model.order.JobStatus;
import ru.job4j.fast_food.domain.model.order.Order;
import ru.job4j.fast_food.domain.model.order.Quantity;
import ru.job4j.fast_food.service.OrderServiceFastFood;

import static ru.job4j.fast_food.domain.model.notification.NotificationType.GENERIC_NOTIFICATION;

@RestController
@RequestMapping("/api")
@PropertySource("classpath:order.properties")
public class OrderController {
    private final OrderServiceFastFood orderService;
    @Autowired
    private KafkaTemplate<Integer, GenericNotification> kafkaTemplate;

    @Value("${kafka.order-notification}")
    private String orderNotification;

    public OrderController(OrderServiceFastFood orderService) {
        this.orderService = orderService;
    }

    @PostMapping("${order.create}")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order savedOrder = orderService.save(order);
        kafkaTemplate.send(orderNotification, new GenericNotification(
                String.format("Your order (id: %s) has been placed", savedOrder.getId()),
                GENERIC_NOTIFICATION));
        return new ResponseEntity<>(orderService.save(order), HttpStatus.ACCEPTED);
    }

    @PostMapping("${order.add}" + "/" + "{productId}")
    public ResponseEntity<Boolean> addProduct(@PathVariable int productId,
                                              @RequestBody Quantity quantity) {
        return new ResponseEntity<>(orderService.addProduct(productId, quantity),
                HttpStatus.ACCEPTED);
    }

    @DeleteMapping("${order.delete}" + "/" + "{orderId}")
    public ResponseEntity<Boolean> clearCart(@PathVariable int orderId) {
        return new ResponseEntity<>(orderService.delete(orderId), HttpStatus.ACCEPTED);
    }

    @PostMapping("${order.update-status}" + "/" + "{orderId}")
    public ResponseEntity<Boolean> addProduct(@PathVariable int orderId,
                                              @RequestBody JobStatus status) {
        return new ResponseEntity<>(orderService.updateStatus(orderId, status),
                HttpStatus.ACCEPTED);
    }
}
