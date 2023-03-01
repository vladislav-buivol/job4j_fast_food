package ru.job4j.fast_food.dish.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.fast_food.dish.repository.IngredientRepository;
import ru.job4j.fast_food.domain.model.dish.Ingredient;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class IngredientService {
    private final IngredientRepository repository;

    public List<Ingredient> findAll() {
        return repository.findAll();
    }

    public Ingredient findById(int id) {
        Optional<Ingredient> optionalIngredient = repository.findById(id);
        if (optionalIngredient.isPresent()) {
            return optionalIngredient.get();
        }
        throw new NoSuchElementException();
    }

    public Ingredient add(Ingredient ingredient) {
        return repository.save(ingredient);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
