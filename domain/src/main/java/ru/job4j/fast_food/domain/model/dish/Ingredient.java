package ru.job4j.fast_food.domain.model.dish;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Table(name = "ingredient")
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "is_allergen")
    private boolean isAllergen;

    @ManyToMany(mappedBy = "ingredients")
    @JsonIgnore
    private transient Set<Dish> dishes;
}
