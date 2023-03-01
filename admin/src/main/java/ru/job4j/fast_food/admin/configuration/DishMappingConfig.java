package ru.job4j.fast_food.admin.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.job4j.fast_food.admin.mapping.DishApiMapping;

@Configuration

public class DishMappingConfig {
    @Bean
    public DishApiMapping dishApiMapping() {
        return new DishApiMapping();
    }
}
