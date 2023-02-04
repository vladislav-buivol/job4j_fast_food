package ru.job4j.fast_food.domain.model.delivery;

import lombok.Data;
import ru.job4j.fast_food.domain.model.customer.Address;

@Data
public class DeliveryInfo {
    private Address address;
    private String phone;
    private String comments;
}
