CREATE TABLE quantity
(
    id         SERIAL PRIMARY KEY,
    product_id INTEGER NOT NULL,
    FOREIGN KEY (product_id) REFERENCES dish (id),
    value      NUMERIC NOT NULL,
    metric     varchar(50)  NOT NULL,
    cart_id    INTEGER,
    FOREIGN KEY (cart_id) REFERENCES cart (id)
);
