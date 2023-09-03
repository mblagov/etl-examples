create table public.employees (
                                  id serial primary key ,
                                  name character varying(30) not null,
                                  department character varying(30) not null,
                                  salary double precision not null
);

insert into public.employees (name, department, salary) values ('Ivan Ivanov', 'Sales', 100),
                                                               ('Petr Petrov', 'Marketing', 90),
                                                               ('Sidor Sidorov', 'R&D', 110);

