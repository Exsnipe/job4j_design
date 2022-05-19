create table body (
	id serial primary key,
	name varchar(256)
);
create table engine (
	id serial primary key,
	name varchar(256)
);
create table gearbox (
	id serial primary key,
	name varchar(255)
);
create table car (
	id serial primary key,
	name varchar (255),
	body_id int references body(id),
	engine_id int references engine(id),
	gearbox_id int references gearbox(id)
);
insert into body (name) values ('седан'), ('хэтчбек'), ('пикап'), ('внедорожник'), ('кабриолет');
insert into engine (name) values ('VT2'), ('SF174'), ('DVX-turbo'), ('FGS-001'), ('TVS-2MS');
insert into gearbox (name) values ('at'), ('cvt'), ('dsg', 'mt');
insert into car (name, body_id, engine_id, gearbox_id) values ('Ford', 1, 4, 1),
('Toyota', 3, 2, 1), ('Renault', 2, 1, 3), ('Kia', 4, 3, 2),
('Lada', 1, 2, 1), ('Honda', 3, 1, 3), ('Hyndai', 2, 4, 2);
insert into car (name, engine_id, gearbox_id) values ('Great Wall', 3, 3);
insert into car (name, body_id, gearbox_id) values ('Dacha', 1, 2);
insert into car (name, body_id, engine_id) values ('Skoda', 2, 4);
select c.name, b.name, e.name, g.name from car as c left join body as b on c.body_id = b.id
left join engine as e on c.engine_id = e.id
left join gearbox as g on c.gearbox_id = g.id;
select e.name, c.name from engine as e left join car as c on e.id = c.engine_id where c.name is null;
select b.name, c.name from body as b left join car as c on b.id = c.body_id where c.name is null;
select g.name, c.name from gearbox as g left join car as c on g.id = c.gearbox_id where c.name is null;
