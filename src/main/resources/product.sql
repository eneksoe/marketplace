create table if not exists products
(
    id               serial primary key,
    name        varchar(20)   not null,
    description varchar(1000) not null,
    price       int           not null,
    city        varchar(50)   not null,
    seller      varchar(50)   not null
);

select * from products