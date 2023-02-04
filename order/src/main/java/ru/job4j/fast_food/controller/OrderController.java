package ru.job4j.fast_food.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.fast_food.domain.model.order.Order;
import ru.job4j.fast_food.domain.model.order.OrderStatus;
import ru.job4j.fast_food.domain.model.order.Quantity;
import ru.job4j.fast_food.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/createOrder")
    public ResponseEntity<Order> createOrder(Order order) {
        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.ACCEPTED);
    }

    @PostMapping("/addProduct/{productId}")
    public ResponseEntity<Boolean> addProduct(@PathVariable int productId,
                                              @RequestBody Quantity quantity) {
        return new ResponseEntity<>(orderService.addProduct(productId, quantity),
                HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<Boolean> clearCart(@PathVariable int orderId) {
        return new ResponseEntity<>(orderService.deleteOrder(orderId),
                HttpStatus.ACCEPTED);
    }

    @PostMapping("/updateStatus")
    public ResponseEntity<Boolean> addProduct(@RequestBody OrderStatus status) {
        return new ResponseEntity<>(orderService.updateStatus(status),
                HttpStatus.ACCEPTED);
    }
}
