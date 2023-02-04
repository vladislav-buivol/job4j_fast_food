package ru.job4j.fast_food.dish.service;


import org.springframework.stereotype.Service;
import ru.job4j.fast_food.domain.model.dish.Dish;

@Service
public interface DishService {
    void addProduct(Dish dish);

    void deleteProduct(Dish dish);

    void updateProduct(Dish dish);

    void findById(int id);
}
