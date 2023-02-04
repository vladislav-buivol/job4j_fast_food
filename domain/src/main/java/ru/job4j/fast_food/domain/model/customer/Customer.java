package ru.job4j.fast_food.domain.model.customer;

import lombok.Data;

@Data
public class Customer {
    private int id;
    private String name;
    private int age;
    private String phone;
    private Address deliveryAddress;
}
