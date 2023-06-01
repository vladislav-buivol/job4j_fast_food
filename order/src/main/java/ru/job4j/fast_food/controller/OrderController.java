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
import ru.job4j.fast_food.publisher.OrderEventPublisher;
import ru.job4j.fast_food.service.OrderServiceFastFood;

@RestController
@RequestMapping("/api")
@PropertySource("classpath:order.properties")
public class OrderController {
    private final OrderServiceFastFood orderService;

    @Autowired
    private KafkaTemplate<Integer, Order> kafkaPreOrderTemplate;
    private final OrderEventPublisher eventPublisher;

    @Value("${kafka.order-preorder}")
    private String preOrder;

    public OrderController(OrderServiceFastFood orderService, OrderEventPublisher eventPublisher) {
        this.orderService = orderService;
        this.eventPublisher = eventPublisher;
    }

    @PostMapping("${order.create}")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        order.setJobStatus(JobStatus.QUEUED_FOR_PROCESSING);
        Order savedOrder = orderService.save(order);
        kafkaPreOrderTemplate.send(preOrder, savedOrder);
        eventPublisher.publishOrderCreatedEvent(savedOrder);
        return new ResponseEntity<>(savedOrder, HttpStatus.ACCEPTED);
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
