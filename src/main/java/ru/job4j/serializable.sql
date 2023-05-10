create table (
    id serial primary key,
    name varchar(50),
    group varchar(20),
    mark integer
);
insert into students(name, group_number, mark) values('Ivan Ivanov', '1', 4);
insert into students(name, group_number, mark) values('Fedor Ivanov', '1', 3);
insert into students(name, group_number, mark) values('Fedor Fedorov', '2', 5);
//транзакция 1
begin transaction isolation level serializable;
select sum(mark) from students;
update students set mark = 1 where id = 1;
//транзакция 2
begin transaction isolation level serializable;
select sum(mark) from students;
update students set mark = 5 where id = 2;
COMMIT;
//транзакция 1
commit;
