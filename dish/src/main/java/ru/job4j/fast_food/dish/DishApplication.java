package ru.job4j.fast_food.dish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DishApplication {
    public static void main(String[] args) {
        SpringApplication.run(DishApplication.class, args);
    }
}
