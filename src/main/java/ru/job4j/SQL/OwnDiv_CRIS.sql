create table ownersX(
                       id serial primary key,
                       name varchar(255)
);

create table devicesX(
                        id serial primary key,
                        name varchar(255),
                        owner_id int references ownersX(id)
);

insert into ownersX(name) values ('Owner 1');
insert into ownersX(name) values ('Owner 2');
insert into ownersX(name) values ('Owner 3');

insert into devicesX(name, owner_id) values ('Device 1', 1);
insert into devicesX(name, owner_id) values ('Device 2', 2);
insert into devicesX(name, owner_id) values ('Device 3', 3);
insert into devicesX(name, owner_id) values ('Device 4', null);
insert into devicesX(name, owner_id) values ('Device 5', null);
insert into devicesX(name, owner_id) values ('Device 6', 1);

select *
from devicesX d
    left join ownersX o on d.owner_id = o.id;

select *
from ownersX o
    right join devicesX d on d.owner_id = o.id;

select *
from devicesX d
         left join ownersX o on d.owner_id = o.id
where o.id is null;

select *
from ownersX o
    left join devicesX d on o.id = d.owner_id;

select *
from devicesX d
    right join ownersX o on d.owner_id = o.id;

select * from devicesX d
    full join ownersX o on d.owner_id = o.id;

select * from devicesX d left join ownersX o on d.owner_id = o.id
union
select * from devicesX d right join ownersX o on d.owner_id = o.id;

select *
from devicesX d
    cross join ownersX o;


--!!Cross join!!
--Этот вид join используется редко. Результатом этого запроса является декартово множество, т.е. все пары элементов.
-- Например, если в таблице 1 N записей, а в таблице 2 M записей, то мы получим в результате N * M записей.
-- Хорошим примером декартова множества является таблица умножения. Синтаксис такой:
--select .. from табл1 cross join табл2 ..
 --Заметьте! on в этом случае не пишется
--!!!Таким образом, данный вид запроса может служить для генерации данных на уровне БД.!!!
create table numbers(
    num int unique
);

insert into numbers(num) values (1);
insert into numbers(num) values (2);
insert into numbers(num) values (3);
insert into numbers(num) values (4);
insert into numbers(num) values (5);
insert into numbers(num) values (6);
insert into numbers(num) values (7);
insert into numbers(num) values (8);
insert into numbers(num) values (9);

select n1.num as a,
       n2.num as b,
       (n1.num * n2.num) as "a*b="
from numbers n1
    cross join numbers n2;