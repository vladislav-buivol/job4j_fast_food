create table delivery_info
(
    id         serial primary key,
    address_id integer,
    FOREIGN KEY (address_id) references address (id),
    phone      varchar(255) not null,
    comment    varchar(255)
)