package ru.job4j.fast_food.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.fast_food.domain.model.kitchen.Preorder;
import ru.job4j.fast_food.domain.model.order.Order;
import ru.job4j.fast_food.service.PreorderService;

@RestController
@PropertySource("classpath:kitchen.properties")
public class KitchenController {
    private final PreorderService preorderService;
    @Autowired
    private KafkaTemplate<Integer, Order> kafkaOrderTemplate;

    @Value("${kafka.preorder-order}")
    private String preorderOrder;

    public KitchenController(PreorderService preorderService) {
        this.preorderService = preorderService;
    }

    @KafkaListener(topics = {"${kafka.order-preorder}"})
    public void preorderListener(ConsumerRecord<Integer, Order> input) {
        System.out.println("Message received to kitchen: " + input);
        Preorder preorder = new Preorder(input.value());
        preorderService.updatePreOrderDetails(preorder);
        preorderService.save(preorder);
        kafkaOrderTemplate.send(preorderOrder, preorder.getOrder());
    }
}
