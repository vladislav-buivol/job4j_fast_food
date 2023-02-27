package ru.job4j.fast_food.admin.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.job4j.fast_food.admin.mapping.DishApiMapping;

@Configuration
@PropertySource("classpath:dishApi.properties")
public class DishMappingConfig {
    @Bean
    public DishApiMapping dishApiMapping() {
        return new DishApiMapping();
    }
}
