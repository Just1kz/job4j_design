create database test1;

create table test1(
                      id serial primary key,
                      name varchar(255),
                      balance double precision,
                      active boolean,
                      note text
);

insert into test1.public.test1(name, balance, active, note) VALUES ('Anton', 100.50, true, 'Сотрудник Банка');

select * from test1;

update test1.public.test1 set balance = 100000.50;

select * from test1;

delete from test1.public.test1;

select * from test1;

