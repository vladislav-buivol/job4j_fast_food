package ru.job4j.fast_food.domain.model.customer;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = "ADDRESS_ID_FK"))
    private Address homeAddress;
}
