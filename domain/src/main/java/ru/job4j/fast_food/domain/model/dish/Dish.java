package ru.job4j.fast_food.domain.model.dish;

import lombok.Data;
import ru.job4j.fast_food.domain.model.order.Product;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Data
@Table(name = "dish")
@Entity
public class Dish implements Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private BigDecimal price;
    private String description;
    private String name;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "dish_ingredient", joinColumns = {
            @JoinColumn(name = "dish_id", referencedColumnName = "id",
                    nullable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "ingredient_id", referencedColumnName = "id", nullable = false)
            })
    private Set<Ingredient> ingredients;

    public Dish() {
    }

    public Dish(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Dish)) {
            return false;
        }
        Dish dish = (Dish) o;
        return id == dish.id && Objects.equals(price, dish.price) && Objects.equals(
                description, dish.description) && Objects.equals(name, dish.name)
                && Objects.equals(ingredients, dish.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, description, name, ingredients);
    }
}
