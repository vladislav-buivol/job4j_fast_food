create table ingredient
(
    id         serial primary key not null,
    name       varchar(50)        not null,
    is_allergen boolean not null
)