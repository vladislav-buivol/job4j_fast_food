package ru.job4j.fast_food.domain.model.order;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany
    @JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "ORDER_ID_FK"))
    private Set<Quantity> products;

    public void add(Quantity quantity) {
        if (!products.contains(quantity)) {
            products.add(quantity);
        } else {
            for (Quantity q : products) {
                if (q.equals(quantity)) {
                    q.setValue(quantity.getValue().add(q.getValue()));
                    return;
                }
            }
        }
    }
}
