CREATE TABLE customer
(
    id         serial primary key,
    name       varchar(255) not null,
    age        integer,
    phone      varchar(255) not null,
    address_id integer,
    FOREIGN KEY (address_id) references address (id)

)