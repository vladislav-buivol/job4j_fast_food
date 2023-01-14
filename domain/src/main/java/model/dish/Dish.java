package model.dish;

import java.math.BigDecimal;
import java.util.List;

public class Dish {
    private int id;
    private BigDecimal price;
    private String description;
    private List<Ingredients> components;
}
