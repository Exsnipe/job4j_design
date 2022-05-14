create table departments (
	id serial primary key,
	name varchar(255)
);
create table employees (
	id serial primary key,
	name varchar(255),
	department_id int references departments(id)
);
insert into departments(name)
values ('бухгалтерия'), ('отдел продаж'), ('логистическая служба'),
('инженерный отдел'), ('служба технической поддержки'), ('цех');
insert into employees(name, department_id)
values ('Миша', 1), ('Саша', 2), ('Паша', 3), ('Коля', 5), ('Юля', 6);
select * from employees as e
left join departments as d on e.department_id = d.id;
select * from employees as e
right join departments as d on e.department_id = d.id;
select * from employees as e
full join departments as d on e.department_id = d.id;
select * from employees as e
cross join departments as d;
select * from departments as d
left join employees as e on e.department_id = d.id where e.name is null;
select * from employees as e
left join departments as d on e.department_id = d.id;
select e.id, e.name, e.department_id, d.id, d.name from departments as d
right join employees as e on d.id = e.department_id;
create table teens (
	id serial primary key,
	name varchar (255),
	gender varchar (255)
);
insert into teens(name, gender)
values ('Саша', 'М'), ('Маша', 'Ж'), ('Коля', 'М'),
('Марина', 'Ж'), ('Петя', 'М'), ('Лариса', 'Ж'), ('Оля', 'Ж');
select t1.name as name1, t2.name as name2 from teens t1
cross join teens t2 where t1.gender != t2.gender;
