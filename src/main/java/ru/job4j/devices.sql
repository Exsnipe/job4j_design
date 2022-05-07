create table devices(
	id serial primary key,
	name varchar(255),
	price float
);
create table people(
	id serial primary key,
	name varchar(255)
);
create table devices_people(
    id serial primary key,
    devices_id int references devices(id),
    people_id int references people(id)
);
insert into people(name) values ('Pasha'), ('Sasha'), ('Kolya');
insert into devices(name, price) values ('notebook', 700), ('phone', 500), ('mp3', 300);
insert into devices_people(devices_id, people_id) values (1, 1), (1, 3), (2, 1), (2, 2), (3, 2), (3, 3);
select avg(price) from devices;
select dp.people_id, avg(d.price) from devices_people as dp join devices as d on dp.devices_id = d.id group by dp.people_id;
select dp.people_id, avg(d.price) from devices_people as dp join devices as d on dp.devices_id = d.id group by dp.people_id having avg(d.price) > 450;


