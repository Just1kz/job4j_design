create table address(
                         id serial primary key,
                         town varchar(250),
                         street varchar(500),
                         home varchar(10),
                         flat int
);

create table peopleADDRESS(
                       id serial primary key,
                       name varchar(255),
                       address_id int references address(id) unique
);

insert into address(town, street, home, flat) values ('Novosibirsk', 'Dachnaya', '37/1', 703);
insert into address(town, street, home, flat) values ('Novosibirsk', 'Promyshlennaya', '14', 48);
insert into address(town, street, home, flat) values ('Novosibirsk', 'Chkalova', '70/1', 103);
insert into address(street, home, flat) values ('Chupina', '15', 3);
insert into address(street, home, flat) values ('Putina', '3', 12);

insert into peopleADDRESS(name, address_id) values ('Anton1', 1);
insert into peopleADDRESS(name, address_id) values ('Anton2', 2);
insert into peopleADDRESS(name, address_id) values ('Anton3', 3);
insert into peopleADDRESS(name, address_id) values ('OtherName1', 4);
insert into peopleADDRESS(name, address_id) values ('OtherName1', 5);

select
t.name as ИМЯ,
p.town as ГОРОД,
p.street as УЛИЦА,
p.home as ДОМ,
p.flat as КВАРТИРА
from peopleADDRESS t
inner join address p on t.address_id = p.id
where p.town is not null;