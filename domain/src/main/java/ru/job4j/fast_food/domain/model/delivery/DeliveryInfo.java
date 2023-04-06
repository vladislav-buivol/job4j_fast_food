package ru.job4j.fast_food.domain.model.delivery;

import lombok.Data;
import ru.job4j.fast_food.domain.model.customer.Address;

import javax.persistence.*;

@Data
@Entity
@Table(name = "delivery_info")
public class DeliveryInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = "ADDRESS_ID_FK"))
    private Address address;
    private String phone;
    private String comments;
}
