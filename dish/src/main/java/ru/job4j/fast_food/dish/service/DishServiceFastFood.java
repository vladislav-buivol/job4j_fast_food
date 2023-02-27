package ru.job4j.fast_food.dish.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.fast_food.dish.repository.DishRepository;
import ru.job4j.fast_food.domain.model.dish.Dish;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DishServiceFastFood implements DishService {
    private final DishRepository repository;

    @Override
    public List<Dish> findAll() {
        return repository.findAll();
    }

    @Override
    public Dish findById(int id) {
        Optional<Dish> optionalDish = repository.findById(id);
        if (optionalDish.isPresent()) {
            return optionalDish.get();
        }
        throw new NoSuchElementException();
    }

    @Override
    public boolean addProduct(Dish dish) {
        return false;
        //return repository.save(dish);
        //todo
    }

    @Override
    public void deleteProduct(Dish dish) {
        repository.delete(dish);
    }
}
