package ru.job4j.fast_food.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.job4j.fast_food.admin.mapping.DishApiMapping;
import ru.job4j.fast_food.domain.model.dish.Dish;

import java.util.List;

@Controller
@PropertySource("classpath:adminController.properties")
public class DishAdminController {
    @Autowired
    private RestTemplate rest;
    @Autowired
    private DishApiMapping dishApiMapping;

    @GetMapping("${admin.index}")
    public String getIndex() {
        return "index";
    }

    @GetMapping("${admin.dish.find-all}")
    public String findAllDishes(Model model) {
        ResponseEntity<List<Dish>> dishes =
                rest.exchange(dishApiMapping.getFindAll(),
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Dish>>() {
                        });

        model.addAttribute("dishes", dishes.getBody());
        return "dishes";
    }

    @PostMapping("${admin.dish.add}")
    public ResponseEntity<Dish> add(@RequestBody Dish dish) {
        return new ResponseEntity<Dish>(
                rest.postForObject(dishApiMapping.getAdd(),
                        dish,
                        Dish.class),
                HttpStatus.ACCEPTED);
    }

    @DeleteMapping("${admin.dish.delete}" + "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        rest.delete(dishApiMapping.getDelete(id));
        return ResponseEntity.ok().build();
    }
}
