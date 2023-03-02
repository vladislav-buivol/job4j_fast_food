package ru.job4j.fast_food.dish.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.fast_food.dish.repository.DishRepository;
import ru.job4j.fast_food.dish.repository.IngredientRepository;
import ru.job4j.fast_food.domain.model.dish.Dish;
import ru.job4j.fast_food.domain.model.dish.Ingredient;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DishServiceFastFood implements DishService {
    private final DishRepository dishRepository;
    private final IngredientRepository ingredientRepository;

    @Override
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    @Override
    public Dish findById(int id) {
        Optional<Dish> optionalDish = dishRepository.findById(id);
        if (optionalDish.isPresent()) {
            return optionalDish.get();
        }
        throw new NoSuchElementException();
    }

    @Override
    public Dish addDish(Dish dish) {

        for (Ingredient ingredient : dish.getIngredients()) {
            System.out.println();
            if (ingredient.getId() == 0) {
                ingredient = ingredientRepository.save(ingredient);
            } else {
                Ingredient existingIngredient = ingredientRepository.findById(ingredient.getId())
                        .orElseThrow(() -> new IllegalArgumentException("Invalid ingredient id"));
                if (!existingIngredient.getName().equals(ingredient.getName())) {
                    throw new IllegalArgumentException("Ingredient name not mathc");
                }
                existingIngredient.setName(ingredient.getName());
                existingIngredient.setAllergen(ingredient.isAllergen());
                ingredient = existingIngredient;
            }
        }
        return dishRepository.save(dish);
    }

    @Override
    public void delete(int id) {
        dishRepository.deleteById(id);
    }
}
