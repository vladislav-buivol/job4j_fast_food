package ru.job4j.fast_food.service;

import org.springframework.stereotype.Service;
import ru.job4j.fast_food.domain.model.customer.ClientCard;
import ru.job4j.fast_food.domain.model.order.OrderStatus;

@Service
public interface CustomerService {
    ClientCard buyCard(ClientCard clientCard);

    OrderStatus checkStatus(int orderId);
}
