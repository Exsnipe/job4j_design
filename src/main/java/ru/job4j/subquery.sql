create table customers(
    id serial primary key,
    first_name text,
    last_name text,
    age int,
    country text
);
insert into customers(first_name, last_name, age, country) values
('Tom', 'Filipson', 32, 'USA'),
('Jack', 'Lask', 41, 'UK'),
('Marta', 'Scott', 29, 'USA'),
('Berta', 'Jankins', 29, 'USA'),
('Migel', 'Brotchevski', 37, 'Canada');
select * from customers where customers.age = (select min(age) from customers);
CREATE TABLE customers_orders(
    id serial primary key,
    amount int,
    customer_id int references customers(id)
);
insert into customers_orders(amount, customer_id) values
(6, 2), (5, 1), (15, 5), (1, 4);
select * from customers
where customers.id not in (select customer_id from customers_orders);