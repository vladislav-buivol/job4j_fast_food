package service;

import model.dish.Dish;

public interface DishService {
    void addDish(Dish dish);

    void deleteDish(Dish dish);

    void updateDish(Dish dish);

    void findById(int id);
}
