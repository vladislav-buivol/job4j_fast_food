package ru.job4j.fast_food.admin.mapping;

import org.springframework.beans.factory.annotation.Value;

public class DishApiMapping {
    @Value("${dish.api.endpoint}")
    private String endpoint;

    @Value("${dish.find-all}")
    public String FIND_ALL;

    @Value("${dish.add}")
    public String ADD;

    public String getEndpoint() {
        return endpoint;
    }

    public String getFindAll() {
        return endpoint + FIND_ALL;
    }

    public String getAdd() {
        return endpoint + ADD;
    }
}
