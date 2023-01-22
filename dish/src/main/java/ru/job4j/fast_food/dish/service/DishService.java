package ru.job4j.fast_food.dish.service;


import ru.job4j.fast_food.domain.model.dish.Dish;

public interface DishService {
    void addDish(Dish dish);

    void deleteDish(Dish dish);

    void updateDish(Dish dish);

    void findById(int id);
}
