create table roles(
    id serial primary key,
    role_name varchar(20)
);
create table users(
    id serial primary key,
    name varchar(50),
    role_id int references roles(id)
);
create table us_rules(
    id serial primary key,
    rule varchar(30)
);
create table roles_us_rules(
    id serial primary key,
    role_id int references roles(id),
    rule_id int references us_rules(id)
);
create table state(
    id serial primary key,
    status varchar(100)
);
create table category(
    id serial primary key,
    category_name varchar(25)
);
create table items(
    id serial primary key,
    item_name varchar(50),
    user_id int references users(id),
    category_id int references category(id),
    state_id int references state(id)
);
create table  comments(
    id serial primary key,
    item_comment varchar(255),
    item_id int references items(id)
);
create table attachs(
    id serial primary key,
    url_file varchar(100),
    item_id int references items(id)
);