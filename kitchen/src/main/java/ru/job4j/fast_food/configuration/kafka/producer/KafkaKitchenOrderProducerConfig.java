package ru.job4j.fast_food.configuration.kafka.producer;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import ru.job4j.fast_food.domain.model.order.Order;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaKitchenOrderProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String kafkaServer;

    @Bean
    public KafkaTemplate<Integer, Order> kafkaKitchenTemplate() {
        return new KafkaTemplate<>(kitchenProducerFactory());
    }

    @Bean
    public ProducerFactory<Integer, Order> kitchenProducerFactory() {
        return new DefaultKafkaProducerFactory<>(kitchenProducerConfigs());
    }

    @Bean
    public Map<String, Object> kitchenProducerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return props;
    }
}
