CREATE TABLE preorder
(
    id                    serial PRIMARY KEY,
    order_id              INT,
    FOREIGN KEY (order_id) REFERENCES order_info (id),
    received_order_status varchar(50) NOT NULL,
    new_order_status      varchar(50) NOT NULL
);