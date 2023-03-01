INSERT INTO dish (id, name, price, description)
VALUES (2, 'Pork steak with cheese', 50, NULL),
       (1, 'Pasta carbonara', 10.3, NULL);


INSERT INTO ingredient (id, name, is_allergen)
VALUES (1, 'Pasta', false),
       (2, 'Cheese', false),
       (3, 'Pork', false),
       (4, 'Salad', false);


INSERT INTO dish_ingredient (dish_id, ingredient_id)
VALUES (1, 1),
       (1, 2),
       (2, 2),
       (2, 3),
       (2, 4);

