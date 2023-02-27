package ru.job4j.fast_food.admin.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Configuration
@Component
public class RestTemplateConfig {
    @Bean
    public RestTemplate getTemplate() {
        return new RestTemplateBuilder()
                .build();
    }
}
