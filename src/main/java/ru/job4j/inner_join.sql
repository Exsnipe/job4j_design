create table tr_groups (
    id serial primary key,
    group_name varchar(10)
);
create table students (
    id serial primary key,
    fio varchar(10),
    group_id references tr_groups(id)
);
insert into tr_groups (group_name) values ('tr-081');
insert into tr_groups (group_name) values ('tr-082');
insert into tr_groups (group_name) values ('tr-083');
insert into students (fio, group_id) values ('fsa', 1);
insert into students (fio, group_id) values ('rhs', 3);
insert into students (fio, group_id) values ('whj', 3);
insert into students (fio, group_id) values ('kqi', 2);
insert into students (fio, group_id) values ('sky', 2);
insert into students (fio, group_id) values ('obj', 1);
insert into students (fio, group_id) values ('kqz', 1);
insert into students (fio, group_id) values ('erg', 2);
insert into students (fio, group_id) values ('uhf', 3);
insert into students (fio, group_id) values ('jfe', 1);
insert into students (fio) values ('rto');
select * from students join tr_groups on students.group_id = tr_groups.id;