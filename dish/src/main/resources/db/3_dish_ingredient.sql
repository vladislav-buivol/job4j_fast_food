CREATE TABLE dish_ingredient
(
    dish_id       INT REFERENCES dish (id) ON DELETE CASCADE,
    ingredient_id INT REFERENCES ingredient (id) ON DELETE CASCADE,
    PRIMARY KEY (dish_id, ingredient_id)
);