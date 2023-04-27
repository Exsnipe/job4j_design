create or replace function tax()
	returns trigger as
$$
	begin
		update products
		set price = price * 1.13
		where id in (select id from inserted);
		return new;
	end;
$$
LANGUAGE 'plpgsql';

create or replace trigger tax
after insert on products
referencing new table as inserted
for each statement
execute procedure tax();

create or replace function tax()
	returns trigger as
$$
	begin
		update products
		set price = price * 1.13
		where id = new.id;
		return new;
	end;
$$
language 'plpgsql';

create or replace trigger tax
before insert on products
for each row
execute procedure tax();

create table history_of_price (
	id serial primary key,
	name varchar(50),
	price integer,
	date timestamp
);

create or replace function input_history_price()
	returns trigger as
$$
	begin
		insert into history_of_price(name, price, date)
		values(new.name, new.price, CURRENT_DATE);
		return new;
	end;
$$
language 'plpgsql';

create or replace trigger input_history_price
after insert on products
for each row
execute procedure input_history_price();


