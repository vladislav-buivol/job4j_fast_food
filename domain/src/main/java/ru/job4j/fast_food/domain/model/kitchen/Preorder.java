package ru.job4j.fast_food.domain.model.kitchen;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.job4j.fast_food.domain.model.order.JobStatus;
import ru.job4j.fast_food.domain.model.order.Order;

import javax.persistence.*;

@Data
@Entity
@Table(name = "preorder")
@NoArgsConstructor
public class Preorder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "received_order_status")
    @Enumerated(EnumType.STRING)
    private JobStatus receivedStatus;

    @Column(name = "new_order_status")
    @Enumerated(EnumType.STRING)
    private JobStatus newStatus;

    public Preorder(Order order) {
        this.order = order;
        this.receivedStatus = order.getJobStatus();
    }
}
