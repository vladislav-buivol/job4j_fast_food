package ru.job4j.fast_food.admin.mapping;

import org.springframework.beans.factory.annotation.Value;

public class DishApiMapping {
    @Value("${dish.api.endpoint}")
    private String endpoint;

    @Value("${dish.find-all}")
    private String findAll;

    @Value("${dish.add}")
    private String add;

    @Value("${dish.find-by-id}")
    private String findById;

    @Value("${dish.delete}")
    private String delete;

    public DishApiMapping() {
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getFindAll() {
        return endpoint + findAll;
    }

    public String getAdd() {
        return endpoint + add;
    }

    public String getFindById() {
        return endpoint + findById;
    }

    public String getDelete(int id) {
        return endpoint + delete + "/" + id;
    }
}
