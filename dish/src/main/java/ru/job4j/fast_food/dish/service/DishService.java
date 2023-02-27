package ru.job4j.fast_food.dish.service;


import org.springframework.stereotype.Service;
import ru.job4j.fast_food.domain.model.dish.Dish;

import java.util.Collection;

@Service
public interface DishService {
    /*todo
       1. Create DB for fast_food_admin
       2. Add liquid base
       3. Add migration scripts (create/update/insert to db)
       4. Implement dish services in postgres
       5. Add restTemplate to admin to use api of fish service
       6. add Thymeleaf to admin
      */
    Collection<Dish> findAll();

    boolean addProduct(Dish dish);

    void deleteProduct(Dish dish);

    Dish findById(int id);
}
