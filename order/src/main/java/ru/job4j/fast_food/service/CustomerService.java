package ru.job4j.fast_food.service;

import ru.job4j.fast_food.domain.model.customer.ClientCard;
import ru.job4j.fast_food.domain.model.order.JobStatus;

public interface CustomerService {
    ClientCard buyCard(ClientCard clientCard);

    JobStatus checkStatus(int orderId);
}
