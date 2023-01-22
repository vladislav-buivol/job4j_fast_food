package ru.job4j.fast_food.domain.model.delivery;

import lombok.Data;

@Data
public class Courier {
    private int id;
    private int orderId;
    private String name;
    private String phone;
    private Status status;

    public enum Status {
        AVAILABLE,
        BUSY
    }
}
