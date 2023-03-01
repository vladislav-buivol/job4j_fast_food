create table dish
(
    id          serial primary key not null,
    name        varchar(50)        not null,
    price       numeric            not null,
    description varchar(255)
)