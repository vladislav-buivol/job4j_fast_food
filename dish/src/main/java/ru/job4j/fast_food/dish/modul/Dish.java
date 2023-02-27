package ru.job4j.fast_food.dish.modul;
/*
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Table(name = "dish")
@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private BigDecimal price;
    private String description;
    private String name;

  /*  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "dish_ingredient", joinColumns = {
            @JoinColumn(name = "dish_id", referencedColumnName = "id",
                    nullable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "ingredient_id", referencedColumnName = "id", nullable = false)
            })
    private List<Ingredient> components;

    public Dish() {
    }

    public Dish(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
*/