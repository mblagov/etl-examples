alter table public.employees add column new_name varchar(30), add column surname varchar(30);

update public.employees set new_name = split_part(name,' ','1'), surname = split_part(name,' ','2');

alter table public.employees drop name;
alter table public.employees rename new_name to name;