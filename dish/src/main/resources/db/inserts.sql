INSERT INTO dish (name, price, description)
VALUES ( 'Pork steak with cheese', 50, NULL),
       ('Pasta carbonara', 10.3, NULL);


INSERT INTO ingredient (id, name, is_allergen)
VALUES ('Pasta', false),
       ('Cheese', false),
       ('Pork', false),
       ( 'Salad', false);


INSERT INTO dish_ingredient (dish_id, ingredient_id)
VALUES (1, 1),
       (1, 2),
       (2, 2),
       (2, 3),
       (2, 4);

