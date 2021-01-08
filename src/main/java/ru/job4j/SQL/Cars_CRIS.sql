create table body (
    id serial primary key,
    name varchar(255)
);

create table engine (
    id serial primary key,
    name varchar(255)
);

create table gearbox (
    id serial primary key,
    name varchar(255)
);

create table car(
   id serial primary key,
   name varchar,
   id_body int references body(id),
   id_engine int references engine(id),
   id_gearbox int references gearbox(id)
);

insert into body(name) VALUES ('Old');
insert into body(name) VALUES ('Classic');
insert into body(name) VALUES ('New');

insert into engine(name) VALUES ('V1');
insert into engine(name) VALUES ('V2');
insert into engine(name) VALUES ('V3');
insert into engine(name) VALUES ('V4');
insert into engine(name) VALUES ('V5');
insert into engine(name) VALUES ('V6');

insert into gearbox(name) VALUES ('AUTO_4P');
insert into gearbox(name) VALUES ('AUTO_5P');
insert into gearbox(name) VALUES ('AUTO_6P');
insert into gearbox(name) VALUES ('MANUAL_4P');
insert into gearbox(name) VALUES ('MANUAL_5P');
insert into gearbox(name) VALUES ('MANUAL_6P');

insert into car(name, id_body, id_engine, id_gearbox) VALUES ('VolgaV1', 1, 1, 4);
insert into car(name, id_body, id_engine, id_gearbox) VALUES ('VolgaV2', 2, 2, 5);
insert into car(name, id_body, id_engine, id_gearbox) VALUES ('VolgaV3', 2, 3, 2);
insert into car(name, id_body, id_engine, id_gearbox) VALUES ('VolgaV4', 3, 4, 6);

--1. Вывести список всех машин и все привязанные к ним детали.
select *
from car t
        left join body b on b.id = t.id_body
        left join engine e on t.id_engine = e.id
        left join gearbox g on t.id_gearbox = g.id;

--2. Вывести отдельно детали,
-- которые не используются в машине, кузова, двигатели, коробки передач.
select *
from body t
        left join car c on t.id = c.id_body
where c.id_body is NULL;

select *
from engine t
         left join car c on t.id = c.id_engine
where c.id_engine is NULL;

select *
from gearbox t
         left join car c on t.id = c.id_gearbox
where c.id_gearbox is NULL;