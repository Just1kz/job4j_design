--1. Создать таблицы и заполнить их начальными данными
create table employeesX (
    id serial primary key,
    name varchar(255)
);

create table departmentsX (
    id serial primary key,
    name varchar(255),
    employees_id int references employeesX(id)
);

insert into employeesX(name) VALUES ('Anton');
insert into employeesX(name) VALUES ('Andrey');
insert into employeesX(name) VALUES ('Denis');
insert into employeesX(name) VALUES ('Petr');
insert into employeesX(name) VALUES ('Stas');
insert into employeesX(name) VALUES ('Anna');
insert into employeesX(name) VALUES ('Yulia');

insert into departmentsx(name, employees_id) VALUES ('1', 1);
insert into departmentsx(name, employees_id) VALUES ('1', 2);

insert into departmentsx(name, employees_id) VALUES ('2', 3);

insert into departmentsx(name, employees_id) VALUES ('3', 4);
insert into departmentsx(name, employees_id) VALUES ('3', 5);

insert into departmentsx(name) VALUES ('4');
insert into departmentsx(name) VALUES ('4');

--2. Выполнить запросы с left, rigth, full, cross соединениями
select *
from employeesX t
left join departmentsX dX on t.id = dX.employees_id;

select *
from departmentsX t
right join employeesX eX on eX.id = t.employees_id;

select *
from employeesX t
full join departmentsX dX on t.id = dX.employees_id;

select *
from employeesX t
cross join departmentsX z;

--3. Используя left join найти работников,
-- которые не относятся ни к одну из департаментов
select *
from employeesX t
left join departmentsX dX on t.id = dX.employees_id
where dX.name is NULL;

--4. Используя left и right join написать запросы,
-- которые давали бы одинаковый результат.
select *
from employeesX t
         left join departmentsX dX on t.id = dX.employees_id
where dX.name = '1';

select *
from departmentsX t
         right join employeesX eX on eX.id = t.employees_id
where t.name = '1';

--5. Создать таблицу teens с атрибутами name, gender и заполнить ее.
-- Используя cross join составить все возможные разнополые пары

create table teens(
   name varchar(255) unique,
   gender varchar(255)
);

insert into teens(name, gender) VALUES ('Anton', 'man');
insert into teens(name, gender) VALUES ('Andrey', 'man');
insert into teens(name, gender) VALUES ('Stas', 'man');
insert into teens(name, gender) VALUES ('Denis', 'man');
insert into teens(name, gender) VALUES ('Masha', 'woman');
insert into teens(name, gender) VALUES ('Anna', 'woman');
insert into teens(name, gender) VALUES ('Lena', 'woman');
insert into teens(name, gender) VALUES ('Dasha', 'woman');

select *
from teens t1
cross join teens t2
where t1.gender != t2.gender
limit 16;