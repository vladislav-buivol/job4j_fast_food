package ru.job4j.fast_food.domain.model.order;

import lombok.Data;
import ru.job4j.fast_food.domain.model.dish.Dish;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Data
@Entity
@Table(name = "quantity")
public class Quantity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "PRODUCT_ID_FK"))
    private Dish product;
    private BigDecimal value;

    @Enumerated(EnumType.STRING)
    private Metric metric;

    public enum Metric {
        AMOUNT, WEIGHT
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Quantity)) {
            return false;
        }
        Quantity quantity = (Quantity) o;
        return Objects.equals(product, quantity.product) && Objects.equals(value,
                quantity.value) && metric == quantity.metric;
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, value, metric);
    }
}
