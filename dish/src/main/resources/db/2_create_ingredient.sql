create table ingredient
(
    id         serial primary key not null,
    name       varchar(50)        not null,
    isAllergen BOOLEAN not null
)