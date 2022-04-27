insert into roles(role_name) values('admin');
insert into users(name, role_id) values('Ivanov', 1);
insert into us_rules(rule) values('full acces');
insert into roles_us_rules(role_id, rule_id) values(1, 1);
insert into category(category_name) values('food');
insert into state(status) values('ordered');
insert into items(item_name, user_id, category_id, state_id)
    values ('milk', 1, 1, 1);
insert into comments(item_comment) values('dom 11.11.2021');
insert into attachs(url_file) values('C:\comments\comment1.txt');
