package ru.job4j.fast_food.domain.model.order;

import lombok.Data;
import ru.job4j.fast_food.domain.model.delivery.DeliveryInfo;
import ru.job4j.fast_food.domain.model.delivery.Payment;

import java.math.BigDecimal;

@Data
public class Order {
    private int id;
    private int customerId;
    private OrderStatus orderStatus;
    private Payment payment;
    private DeliveryInfo deliveryInfo;
    private Cart cart;
    private BigDecimal totalPrice;
}
