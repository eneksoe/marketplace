create table if not exists products
(
    id                  serial primary key,
    name                varchar(200)   not null,
    description         varchar(10000) not null,
    price               int            not null,
    city                varchar(50)    not null,
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
    user_image_id          int,
    constraint fk_images
      foreign key (user_image_id)
        references images (id),
    password        varchar,
    date_of_created timestamp
);

create table if not exists user_role
(
user_id bigint,
constraint fk_users
foreign key (user_id)
references users (id),
roles varchar
)