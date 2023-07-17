create table if not exists results (id serial primary key, result_date timestamp, name text);
insert into results(name, result_date) values('run 3 km', '2023-05-09');
insert into results(name, result_date) values('sweam 100 m', '2023-05-10');
insert into results(name, result_date) values('jump with parachute', '2023-05-11');
