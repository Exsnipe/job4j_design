create view show_active_orders_group_by_autors as select s.name, count(a.name),
 a.name from students s join orders o on o.student_id = s.id join books b on o.book_id = b.id
join autors a on b.autor_id = a.id where o.active is true group by (s.name, a.name)