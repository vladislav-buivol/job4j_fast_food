CREATE TABLE notification
(
    id      SERIAL PRIMARY KEY,
    type    VARCHAR(255),
    message TEXT
);