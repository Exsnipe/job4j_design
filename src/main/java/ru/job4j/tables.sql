create table person(
    id serial primary key,
    name varchar(255)
);
create table car(
    id serial primary key,
    owner_id int references person(id)
);
create table wife(
    id serial primary key,
    name varchar(255)
);
create table husbend(
    id serial primary key,
    name varchar(255)
);
create table husbends_wifes(
    id serial primary key,
    husbends_id int references husbend(id) unique,
    wifes_id int references wife(id) unique
);
create table employees(
    id serial primary key,
    name varchar(255)
);
create table projects(
    id serial primary key,
    project_name varchar(255)
);
create  table projects_employees(
    id serial primary  key,
    employees_id int references employees(id),
    projects_id int references projects(id)
);