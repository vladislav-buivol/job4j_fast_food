create table dish
(
    id          serial primary key not null,
    price       numeric            not null,
    description varchar(255),
    name        varchar(50)        not null
)