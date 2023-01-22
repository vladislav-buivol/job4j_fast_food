package ru.job4j.fast_food.domain.model.delivery;

import lombok.Data;
import ru.job4j.fast_food.domain.model.dish.Dish;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Order {
    private int id;
    private int clientId;
    private Status status;
    private Payment payment;
    private DeliveryInfo deliveryInfo;
    private List<Dish> dishes;
    private BigDecimal totalPrice;

    public enum Status {
        QUEUED_FOR_PROCESSING,
        IN_PROGRESS,
        READY,
        CANCELLED
    }
}
