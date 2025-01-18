create table tr_groups (
    id serial primary key,
    group_name varchar(10)
);
create table students (
    id serial primary key,
    fio varchar(10),
    group_id int references tr_groups(id)
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
select s.id, s.fio as фио, s.group_id, tr.group_name as имя_группы
from students as s join tr_groups as tr on s.group_id = tr.id;
select students.id, students.fio as фио, students.group_id, trg.group_name as имя_группы,
 trg.id from students join tr_groups as trg on students.group_id = trg.id;
