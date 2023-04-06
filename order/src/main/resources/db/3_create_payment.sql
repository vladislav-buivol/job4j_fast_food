create table payment
(
    id   serial primary key,
    date timestamp not null,
    billing_address integer,
    FOREIGN KEY (billing_address) references address(id),
    status varchar(50) not null,
    type varchar(50) not null
)