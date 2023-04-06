package ru.job4j.fast_food.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.job4j.fast_food.domain.model.notification.GenericNotification;
import ru.job4j.fast_food.repository.NotificationRepository;


@Service
@Data
public class NotificationServiceFastFood implements NotificationService {
    private final NotificationRepository notificationRepository;

    public NotificationServiceFastFood(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public GenericNotification save(GenericNotification genericNotification) {
        return notificationRepository.save(genericNotification);
    }

    public void delete(int notificationId) {
        notificationRepository.deleteById(notificationId);
    }
}
