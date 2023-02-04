package ru.job4j.fast_food.service;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.fast_food.domain.model.order.Order;
import ru.job4j.fast_food.domain.model.order.OrderStatus;
import ru.job4j.fast_food.domain.model.order.Quantity;

@Service
public interface OrderService {
    Order createOrder(Order order);

    boolean addProduct(int productId, Quantity quantity) throws ResponseStatusException;

    boolean updateStatus(OrderStatus status) throws ResponseStatusException;

    boolean deleteOrder(int orderId);
}
