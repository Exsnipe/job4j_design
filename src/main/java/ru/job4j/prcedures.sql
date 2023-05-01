create or replace procedure delete_data(i_id integer)
language 'plpgsql'
as
$$
	begin
		delete from products where id = i_id;
	end
$$;

create or replace function f_delete_data()
returns void
language 'plpgsql'
as
$$
	begin
	delete from products where price < 0;
	end
$$;