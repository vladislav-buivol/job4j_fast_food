package ru.job4j.fast_food.service.notification;

import org.springframework.stereotype.Service;
import ru.job4j.fast_food.domain.model.notification.GenericNotification;
import ru.job4j.fast_food.domain.model.notification.NotificationType;
import ru.job4j.fast_food.service.NotificationServiceFastFood;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Service
public class NotificationProcessService {
    private final NotificationServiceFastFood notificationServiceFastFood;

    private Map<NotificationType, Consumer<GenericNotification>> map = new HashMap<>() {{

    }};

    public NotificationProcessService(NotificationServiceFastFood notificationServiceFastFood) {
        this.notificationServiceFastFood = notificationServiceFastFood;
        map.put(NotificationType.GENERIC_NOTIFICATION,
                notificationServiceFastFood::save
        );
    }

    public void handle(GenericNotification notification) {
        map.get(notification.type()).accept(notification);
    }
}
