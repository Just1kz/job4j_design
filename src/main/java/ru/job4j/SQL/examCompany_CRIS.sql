create table if not exists company (
                                       id serial primary key ,
                                       name character varying
);

create table if not exists person (
                                      id integer NOT NULL,
                                      name character varying,
                                      company_id int references company(id)
);

insert into company(id, name) VALUES (1, 'SBERBANK');
insert into company(id, name) VALUES (2, 'VTB');
insert into company(id, name) VALUES (3, 'Job4j');

insert into person(id, name, company_id) VALUES (1, 'Anton', 1);
insert into person(id, name, company_id) VALUES (2, 'Denis', 1);
insert into person(id, name, company_id) VALUES (3, 'Yura', 1);
insert into person(id, name, company_id) VALUES (4, 'Petr', 1);
insert into person(id, name, company_id) VALUES (5, 'Aleksey', 1);
insert into person(id, name, company_id) VALUES (6, 'Sergey', 1);
insert into person(id, name, company_id) VALUES (7, 'Victor', 1);

insert into person(id, name, company_id) VALUES (8, 'Pasha', 2);
insert into person(id, name, company_id) VALUES (9, 'Grisha', 2);

insert into person(id, name, company_id) VALUES (10, 'Stas', 3);
insert into person(id, name, company_id) VALUES (11, 'Rail', 3);
insert into person(id, name, company_id) VALUES (12, 'Andrey', 3);
insert into person(id, name, company_id) VALUES (13, 'Petr', 3);

SELECT
t.name as ИМЯ,
       c.name as КОМПАНИЯ
from person t
left join company c on t.company_id = c.id
where t.id != 5;

select c.name,
       count(p.id)
from company c left join person  p on c.id = p.company_id
group by c.name
order by count(p.id) desc
limit 1;