create database if not exists product_db;

use product_db;

create table if not exists categories (
    id int primary key auto_increment,
    name varchar(50) not null,
    link varchar(50) not null
);

create table if not exists products (
    id bigint primary key auto_increment,
    category_id int not null,
    name varchar(50) not null,
    description varchar(250) not null,
    link varchar(250) not null,
    img_url varchar(250),
    price double,
    qty int,
    constraint products_categories_fk foreign key (category_id) references categories(id)
);

insert into categories (name, link) values
    ('Quần áo nam', 'quan-ao-nam'),
    ('Quần áo nữ', 'quan-ao-nu')
;

insert into products (category_id, name, description, link, img_url, price, qty) values
    (1, 'Quần Jeans', 'Quần Jeans nam rách gối', 'quan-jeans-nam-rach-goi', 'no-img.jpg', 350, 15),
    (1, 'Áo Sơ mi', 'Áo Sơ mi nam trắng', 'ao-somi-nam-trang', 'no-img.jpg', 250, 15),
    (2, 'Chân váy', 'Chân váy đen', 'chan-vay-den', 'no-img.jpg', 350, 15),
    (2, 'Áo thun nữ', 'Áo thun nữ', 'ao-thun-nu', 'no-img.jpg', 250, 15)
;


