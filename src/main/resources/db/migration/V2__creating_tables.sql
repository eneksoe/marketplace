create table if not exists products
(
    id                  serial primary key,
    name                varchar(200)   not null,
    description         varchar(10000) not null,
    price               int            not null,
    city                varchar(50)    not null,
    seller              varchar(50)    not null,
    preview_image_id    int,
    date_of_created      timestamp
);

create table if not exists images
(
    id                  serial primary key,
    name                varchar,
    original_file_name  varchar(100),
    size                int,
    content_type        varchar,
    is_preview_image    boolean,
    bytes               bigint,
    product_id          int,
     constraint fk_products
        foreign key (product_id)
            references products (id)
);

create table if not exists users
(
    id serial primary key,
    email           varchar,
    phone_number    varchar,
    name            varchar,
    active          boolean,
    avatar_image_id          int,
    constraint fk_images
      foreign key (avatar_image_id)
        references images (id),
    password        varchar,
    role            varchar,
    date_of_created timestamp
);