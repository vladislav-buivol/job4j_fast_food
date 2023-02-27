package ru.job4j.fast_food.dish.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.fast_food.dish.service.DishServiceFastFood;
import ru.job4j.fast_food.domain.model.dish.Dish;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class DishController {
    private final DishServiceFastFood dishService;

    @GetMapping("/hello")
    public ResponseEntity<List<Dish>> convert() {
        return new ResponseEntity<>((List<Dish>) dishService.findAll(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/add")
    public ResponseEntity<Boolean> add(@RequestBody Dish dish) {
        return new ResponseEntity<>(dishService.addProduct(dish), HttpStatus.ACCEPTED);
    }

}
