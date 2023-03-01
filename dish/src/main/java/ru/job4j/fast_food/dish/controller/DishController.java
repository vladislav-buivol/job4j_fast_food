package ru.job4j.fast_food.dish.controller;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.fast_food.dish.service.DishServiceFastFood;
import ru.job4j.fast_food.domain.model.dish.Dish;

import java.util.List;

@RestController
@PropertySource("classpath:dishController.properties")
@AllArgsConstructor
@RequestMapping("${dish.api}")
public class DishController {
    private final DishServiceFastFood dishService;

    @GetMapping("${dish.find-all}")
    public ResponseEntity<List<Dish>> findAll() {
        return new ResponseEntity<>(dishService.findAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("${dish.find-by-id}" + "/{id}")
    public ResponseEntity<Dish> findById(@PathVariable String id) {
        return new ResponseEntity<>(dishService.findById(Integer.parseInt(id)), HttpStatus.ACCEPTED);
    }

    @PostMapping("${dish.add}")
    public ResponseEntity<Dish> add(@RequestBody Dish dish) {
        return new ResponseEntity<>(dishService.addDish(dish), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("${dish.delete}"+"/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        dishService.delete(id);
        return ResponseEntity.ok().build();
    }

}
