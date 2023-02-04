package ru.job4j.fast_food.domain.model.delivery;

import lombok.Data;
import ru.job4j.fast_food.domain.model.customer.Address;

import java.util.Date;

@Data
public class Payment {
    private int id;
    private Date date;
    private Address billingAddress;
    private Status status;
    private Type type;

    public enum Status {
        SUCCESSFUL,
        FAILED
    }

    public enum Type {
        CARD,
        CASH
    }

}
