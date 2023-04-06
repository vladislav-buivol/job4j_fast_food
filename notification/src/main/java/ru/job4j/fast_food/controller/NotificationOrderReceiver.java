package ru.job4j.fast_food.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.fast_food.domain.model.notification.GenericNotification;
import ru.job4j.fast_food.service.notification.NotificationProcessService;

@RestController
@PropertySource("classpath:notification.properties")
public class NotificationOrderReceiver {
    private final NotificationProcessService notificationHandlerService;

    public NotificationOrderReceiver(NotificationProcessService notificationHandlerService) {
        this.notificationHandlerService = notificationHandlerService;
    }

    @KafkaListener(topics = {"${kafka.order-notification}"})
    public void listenStatistic(ConsumerRecord<Integer, GenericNotification> input) {
        notificationHandlerService.handle(input.value());
    }
}
