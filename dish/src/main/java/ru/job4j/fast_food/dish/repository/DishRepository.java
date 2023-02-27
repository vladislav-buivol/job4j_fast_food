package ru.job4j.fast_food.dish.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.fast_food.domain.model.dish.Dish;

import java.util.List;

@Repository
public interface DishRepository extends CrudRepository<Dish, Integer> {
    List<Dish> findAll();
}
