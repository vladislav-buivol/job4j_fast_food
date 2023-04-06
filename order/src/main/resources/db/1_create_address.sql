CREATE TABLE address
(
    id         serial primary key,
    city       varchar(255) not null,
    street     varchar(255) not null,
    house_nr   varchar(255) not null,
    apartments varchar(255) not null,
    post_code  integer not null
)