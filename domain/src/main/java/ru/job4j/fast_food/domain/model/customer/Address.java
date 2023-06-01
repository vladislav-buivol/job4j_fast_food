package ru.job4j.fast_food.domain.model.customer;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String city;
    private String street;
    @Column(name = "house_nr")
    private String houseNr;
    private String apartments;

    @Column(name = "post_code")
    private int postCode;
}
