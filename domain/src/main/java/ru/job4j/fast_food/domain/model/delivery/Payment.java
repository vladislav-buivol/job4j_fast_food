package ru.job4j.fast_food.domain.model.delivery;

import lombok.Data;
import ru.job4j.fast_food.domain.model.customer.Address;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "payment")
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "billing_address", foreignKey = @ForeignKey(name = "ADDRESS_ID_FK"))
    private Address billingAddress;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
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
