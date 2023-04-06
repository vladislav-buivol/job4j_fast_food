package ru.job4j.fast_food.service;

import ru.job4j.fast_food.domain.model.notification.GenericNotification;

public interface NotificationService {
    GenericNotification save(GenericNotification genericNotification);

    void delete(int notificationId);
}
