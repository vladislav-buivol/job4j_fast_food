package model.client;

import lombok.Data;

@Data
public class Client {
    private int id;
    private String name;
    private int age;
    private String phone;
    private Address deliveryAddress;
}
