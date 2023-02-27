package ru.job4j.fast_food.domain.model.dish;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "ingredient")
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private boolean isAllergen;
}
