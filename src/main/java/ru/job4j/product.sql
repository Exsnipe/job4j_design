create table type (
    id serial primary key,
    name varchar(30)
);
create table  product(
	id serial primary key,
	name varchar(30),
	type_id int references type(id),
	expired_date date,
	price int
);
insert into type(name) values ('СЫР'), ('МОЛОКО'), ('ДЕСЕРТ'), ('ХЛЕБ');
insert into product (name, type_id, expired_date, price)
values ('Пормезан', 5, '2022-05-25', 200),
('Вкуснотеево', 2, '2022-05-09', 50),
('Гауда', 5, '2022-05-20', 350),
('Бородинский', 4, '2022-05-08', 35),
('Торт',  3, '2022-06-14', 550),
('Липецкое мороженое', 3, '2022-06-15', 350),
('мороженое эскимо', 3, '2022-05-08', 35);
select p.name from product as p
join type as t on p.type_id = t.id where t.name = 'СЫР';
select p.name from product as p where p.name like '%мороженое%';
select name, expired_date from product where expired_date < current_date;
select * from product order by price desc limit 1;
select t.name, count(*) from product as p join type as t
on p.type_id = t.id group by t.name;
select p.name, t.name from product as p join type as t
on p.type_id = t.id where t.name = 'СЫР' or t.name = 'МОЛОКО';
select t.name, count(*) from product as p join type as t
on p.type_id = t.id group by t.name having count(*) < 3;
select p.name, t.name, p.expired_date, p.price
from product as p join type as t on p.type_id = t.id;