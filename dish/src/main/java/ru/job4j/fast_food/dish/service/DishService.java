package ru.job4j.fast_food.dish.service;


import org.springframework.stereotype.Service;
import ru.job4j.fast_food.domain.model.dish.Dish;

import java.util.Collection;

@Service
public interface DishService {

    Collection<Dish> findAll();

    Dish addDish(Dish dish);

    void delete(int id);

    Dish findById(int id);
}
