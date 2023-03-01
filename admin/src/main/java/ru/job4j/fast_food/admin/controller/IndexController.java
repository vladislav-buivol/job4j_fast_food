package ru.job4j.fast_food.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import ru.job4j.fast_food.admin.mapping.DishApiMapping;
import ru.job4j.fast_food.domain.model.dish.Dish;

import java.util.List;

@Controller
@PropertySource("classpath:indexController.properties")
public class IndexController {
    @Autowired
    private RestTemplate rest;
    @Autowired
    private DishApiMapping dishApiMapping;

    @GetMapping("${admin.index}")
    public String getIndex() {
        return "index";
    }

    @GetMapping("${admin.dish}")
    public String getDishes(Model model) {
        ResponseEntity<List<Dish>> dishes =
                sendRequest(new ParameterizedTypeReference<List<Dish>>() {
                }, HttpMethod.GET, dishApiMapping.getFindAll());
        model.addAttribute("dishes", dishes.getBody());
        return "dishes";
    }

    private <T> ResponseEntity<T> sendRequest(
            ParameterizedTypeReference<T> parameterizedTypeReference,
            HttpMethod method, String url) {
        return rest.exchange(url,
                method,
                null,
                parameterizedTypeReference);
    }
}
