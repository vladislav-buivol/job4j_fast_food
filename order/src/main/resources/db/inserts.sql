INSERT INTO address (city, street, house_nr, apartments, post_code)
VALUES ('New York', '5th Ave', '1', '101', 10001);

INSERT INTO customer (name, age, phone, address_id)
VALUES ('John Doe', 30, '+1-202-555-0112', 1);

INSERT INTO payment (date, billing_address, status, type)
VALUES ('2022-01-01 12:00:00', 1, 'SUCCESSFUL', 'CARD');

INSERT INTO delivery_info (address_id, phone, comment)
VALUES (1, '+1-202-555-0112', 'Leave at front door');

INSERT INTO cart DEFAULT
VALUES;

INSERT INTO quantity (product_id, value, metric, cart_id)
VALUES (6, 2.5, 'WEIGHT', 1);

INSERT INTO quantity (product_id, value, metric, cart_id)
VALUES (10, 2.5, 'WEIGHT', 1);

INSERT INTO order_info (customer_id, order_status, payment_id, delivery_info_id, cart_id, total_price)
VALUES (1, 'QUEUED_FOR_PROCESSING', 1, 1, 1, 100);