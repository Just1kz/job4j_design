create table type (
   id serial primary key,
   name varchar(255)
);

create table product (
   id serial primary key,
   name varchar(255),
   type_id int references type(id),
   expired_date timestamp,
   price float
);

insert into type(name) VALUES ('СЫР');
insert into type(name) VALUES ('МОЛОКО');
insert into type(name) VALUES ('МОРОЖЕННОЕ');

insert into product(name, type_id, expired_date, price) VALUES ('СЫР1', 1, date '2021-01-15', 150);
insert into product(name, type_id, expired_date, price) VALUES ('СЫР2', 1, date '2021-01-08', 99);
insert into product(name, type_id, expired_date, price) VALUES ('СЫР3', 1, date '2021-02-02', 200);

insert into product(name, type_id, expired_date, price) VALUES ('Мороженное1', 3, date '2021-01-15', 55);
insert into product(name, type_id, expired_date, price) VALUES ('Мороженное2', 3, date '2021-01-08', 29.50);
insert into product(name, type_id, expired_date, price) VALUES ('Мороженное3', 3, date '2021-02-10', 99.99);

insert into product(name, type_id, expired_date, price) VALUES ('Молоко1', 2, date '2021-02-10', 70);
insert into product(name, type_id, expired_date, price) VALUES ('Молоко2', 2, date '2021-01-10', 69);
insert into product(name, type_id, expired_date, price) VALUES ('Молоко3', 2, date '2021-01-18', 55);
insert into product(name, type_id, expired_date, price) VALUES ('Молоко4', 2, date '2021-01-13', 69);
insert into product(name, type_id, expired_date, price) VALUES ('Молоко5', 2, date '2021-02-15', 82.5);
insert into product(name, type_id, expired_date, price) VALUES ('Молоко6', 2, date '2021-02-13', 99);
insert into product(name, type_id, expired_date, price) VALUES ('Молоко7', 2, date '2021-01-20', 68.75);
insert into product(name, type_id, expired_date, price) VALUES ('Молоко8', 2, date '2021-01-16', 96);
insert into product(name, type_id, expired_date, price) VALUES ('Молоко9', 2, date '2021-02-15', 75.35);
insert into product(name, type_id, expired_date, price) VALUES ('Молоко10', 2, date '2021-01-08', 59.99);
insert into product(name, type_id, expired_date, price) VALUES ('Молоко11', 2, date '2021-01-07', 49.99);

--1. Написать запрос получение всех продуктов с типом "СЫР"
select
*
from product t
join type t2 on t.type_id = t2.id
where t2.name in ('СЫР');

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
select
    *
from product t
where t.name LIKE ('%Мороженное%');

--3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
select
    *
from product t
where t.expired_date > (current_date + interval '1 month' - interval '9 day');

--4. Написать запрос, который выводит самый дорогой продукт.

select
t.name,
max(t.price)
from product t
         join type t2 on t.type_id = t2.id
group by t.name
limit 1;

--5. Написать запрос, который выводит количество всех продуктов определенного типа.
select
t2.name,
       count(*)
from product t
         join type t2 on t.type_id = t2.id
group by t2.name;

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select
    *
from product t
         join type t2 on t.type_id = t2.id
where t2.id = 1 or t2.id = 2;

--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
select
    t2.name,
    count(*)
from product t
         join type t2 on t.type_id = t2.id
group by t2.name
having count(*) < 10;

--8. Вывести все продукты и их тип.
select
    *
from product t
         join type t2 on t.type_id = t2.id;

