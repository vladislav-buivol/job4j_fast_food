package ru.job4j.fast_food.domain.model.notification;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "notification")
public class GenericNotification implements Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private NotificationType type;
    private String message;

    public GenericNotification(String message, NotificationType type) {
        this.message = message;
        this.type = type;
    }

    public GenericNotification() {

    }

    @Override
    public NotificationType type() {
        return type;
    }
}
