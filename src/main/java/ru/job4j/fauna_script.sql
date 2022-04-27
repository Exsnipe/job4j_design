create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);
insert into fauna (name, avg_age, discovery_date) values ('cat', 10, date '0020-12-12');
insert into fauna (name, avg_age, discovery_date) values ('small fish nemo', 2, date '1567-12-13');
insert into fauna (name, avg_age, discovery_date) values ('dino', 10111, date '0001-06-25');
insert into fauna (name, avg_age) values ('dog', 15);
select * from fauna where name like '%fish%';
select * from fauna where avg_age > 10000 and avg_age < 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '1950-01-01';
