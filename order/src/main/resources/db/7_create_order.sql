CREATE TABLE order_info
(
    id               SERIAL PRIMARY KEY,
    customer_id      INTEGER,
    FOREIGN KEY (customer_id) REFERENCES customer (id),
    order_status     varchar(50) NOT NULL,
    payment_id       INTEGER,
    FOREIGN KEY (payment_id) REFERENCES payment (id),
    delivery_info_id INTEGER,
    FOREIGN KEY (delivery_info_id) REFERENCES delivery_info (id),
    cart_id          INTEGER,
    FOREIGN KEY (cart_id) REFERENCES cart (id),
    total_price      NUMERIC      NOT NULL
);

