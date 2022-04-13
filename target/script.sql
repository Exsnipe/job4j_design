create table airplanes(
	id serial primary key,
	model varchar(10),
	crew int,
	fly_distance int
)
select * from airplanes;
insert into airplanes(model, crew, fly_distance) values('L-410', 3, 850);
select * from airplanes;
update airplanes set model = 'An-26';
select * from airplanes;
delete from airplanes;
select * from airplanes;