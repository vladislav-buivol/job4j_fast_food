package ru.job4j.fast_food.service;

import org.springframework.web.server.ResponseStatusException;
import ru.job4j.fast_food.domain.model.order.Order;
import ru.job4j.fast_food.domain.model.order.JobStatus;
import ru.job4j.fast_food.domain.model.order.Quantity;

public interface OrderService {
    Order save(Order order);

    boolean addProduct(int orderId, Quantity quantity) throws ResponseStatusException;

    boolean updateStatus(int orderId, JobStatus status) throws ResponseStatusException;

    boolean delete(int orderId);
}
