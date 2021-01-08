create table devices(
                        id serial primary key,
                        name varchar(255),
                        price float
);

create table peopleZ(
                       id serial primary key,
                       name varchar(255)
);

create table devices_people(
                               id serial primary key,
                               device_id int references devices(id),
                               people_id int references peopleZ(id)
);

insert into devices(name, price) VALUES ('Mouse', 1000);
insert into devices(name, price) VALUES ('Monitor', 7500);
insert into devices(name, price) VALUES ('Keyboard', 2500);
insert into devices(name, price) VALUES ('SoundSystem', 6000);
insert into devices(name, price) VALUES ('Headphones', 4500);
insert into devices(name, price) VALUES ('HeadphonesWithBluetooth', 10500);

insert into peoplez(name) VALUES ('Anton');
insert into peoplez(name) VALUES ('Anna');
insert into peoplez(name) VALUES ('Denis');

insert into devices_people(device_id, people_id) VALUES(2, 1);
insert into devices_people(device_id, people_id) VALUES(6, 1);
insert into devices_people(device_id, people_id) VALUES(4, 1);

insert into devices_people(device_id, people_id) VALUES(1, 2);
insert into devices_people(device_id, people_id) VALUES(5, 2);
insert into devices_people(device_id, people_id) VALUES(4, 2);

insert into devices_people(device_id, people_id) VALUES(2, 3);
insert into devices_people(device_id, people_id) VALUES(3, 3);
insert into devices_people(device_id, people_id) VALUES(5, 3);

select
    s.name,
    avg(d.price)
from devices_people as ss
         join peoplez s on ss.people_id = s.id
join devices d on ss.device_id = d.id
group by s.name;

select
    s.name,
    avg(d.price)
from devices_people as ss
         join peoplez s on ss.people_id = s.id
         join devices d on ss.device_id = d.id
group by s.name
having avg(d.price) > 5000;
