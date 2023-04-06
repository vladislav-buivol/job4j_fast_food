package ru.job4j.fast_food.service;

import org.springframework.stereotype.Service;
import ru.job4j.fast_food.domain.model.customer.ClientCard;
import ru.job4j.fast_food.domain.model.order.JobStatus;

@Service
public class CustomerServiceFastFood implements CustomerService {
    @Override
    public ClientCard buyCard(ClientCard clientCard) {
        return null;
    }

    @Override
    public JobStatus checkStatus(int orderId) {
        return null;
    }
}
