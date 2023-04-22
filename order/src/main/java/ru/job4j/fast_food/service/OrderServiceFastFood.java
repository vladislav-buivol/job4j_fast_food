package ru.job4j.fast_food.service;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.fast_food.domain.model.order.JobStatus;
import ru.job4j.fast_food.domain.model.order.Order;
import ru.job4j.fast_food.domain.model.order.Quantity;
import ru.job4j.fast_food.repository.OrderRepository;

import java.util.Set;
import java.util.function.Consumer;

@Data
@Service
public class OrderServiceFastFood implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceFastFood(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public boolean addProduct(int orderId, Quantity quantity) throws ResponseStatusException {
        processOrderOrThrowNotFoundException(orderId, order -> {
            addQuantityToOrder(quantity, order);
            orderRepository.save(order);
        });
        return true;
    }

    @Override
    public boolean updateStatus(int orderId, JobStatus status) throws ResponseStatusException {
        processOrderOrThrowNotFoundException(orderId, order -> {
            order.setJobStatus(status);
            orderRepository.save(order);
        });
        return false;
    }

    @Override
    public boolean delete(int orderId) {
        processOrderOrThrowNotFoundException(orderId, order -> orderRepository.deleteById(orderId));
        return true;
    }

    private void processOrderOrThrowNotFoundException(Integer orderId,
                                                      Consumer<Order> orderConsumer) {
        orderRepository.findById(orderId).ifPresentOrElse(orderConsumer, () -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Order with id %s not found", orderId));
        });
    }

    private void addQuantityToOrder(Quantity quantity, Order order) {
        Set<Quantity> products = order.getCart().getProducts();
        if (!products.contains(quantity)) {
            products.add(quantity);
        } else {
            for (Quantity q : products) {
                if (q.equals(quantity)) {
                    q.setValue(quantity.getValue().add(q.getValue()));
                    return;
                }
            }
        }
    }
}
