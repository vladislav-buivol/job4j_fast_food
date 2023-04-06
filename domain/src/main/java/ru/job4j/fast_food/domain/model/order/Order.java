package ru.job4j.fast_food.domain.model.order;

import lombok.Data;
import ru.job4j.fast_food.domain.model.customer.Customer;
import ru.job4j.fast_food.domain.model.delivery.DeliveryInfo;
import ru.job4j.fast_food.domain.model.delivery.Payment;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "order_info")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "CUSTOMER_ID_FK"))
    private Customer customer;

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private JobStatus jobStatus;

    @ManyToOne
    @JoinColumn(name = "payment_id", foreignKey = @ForeignKey(name = "PAYMENT_ID_FK"))
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "delivery_info_id", foreignKey = @ForeignKey(name = "DELIVERY_INFO_ID_FK"))
    private DeliveryInfo deliveryInfo;

    @ManyToOne
    @JoinColumn(name = "cart_id", foreignKey = @ForeignKey(name = "CART_ID_FK"))
    private Cart cart;
    private BigDecimal totalPrice;
}
