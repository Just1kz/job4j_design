create table if not exists meeting(
    id serial primary key,
    name varchar
);

create table if not exists userZ(
    id serial primary key,
    name varchar
);

create table if not exists meeting_userZ(
    id_meeting int references meeting(id),
    id_userZ int references userZ(id),
    status_of_participation boolean default false
);

insert into meeting(name) values ('work1');
insert into meeting(name) values ('work2');
insert into meeting(name) values ('work3');
insert into meeting(name) values ('work4');
insert into meeting(name) values ('work5');

insert into userZ(name) values ('Anton');
insert into userZ(name) values ('Rail');
insert into userZ(name) values ('Stas');
insert into userZ(name) values ('Petr');
insert into userZ(name) values ('Aleksei');
insert into userZ(name) values ('Jenia');
insert into userZ(name) values ('Lena');

insert into meeting_userZ(id_meeting, id_userZ, status_of_participation) VALUES (1, 1, true);
insert into meeting_userZ(id_meeting, id_userZ, status_of_participation) VALUES (1, 2, true);
insert into meeting_userZ(id_meeting, id_userZ, status_of_participation) VALUES (1, 3, true);
insert into meeting_userZ(id_meeting, id_userZ, status_of_participation) VALUES (2, 2, false);
insert into meeting_userZ(id_meeting, id_userZ, status_of_participation) VALUES (2, 3, true);
insert into meeting_userZ(id_meeting, id_userZ, status_of_participation) VALUES (2, 4, true);
insert into meeting_userZ(id_meeting, id_userZ, status_of_participation) VALUES (3, 1, false);
insert into meeting_userZ(id_meeting, id_userZ, status_of_participation) VALUES (3, 5, true);
insert into meeting_userZ(id_meeting, id_userZ, status_of_participation) VALUES (3, 6, true);
insert into meeting_userZ(id_meeting, id_userZ, status_of_participation) VALUES (4, 7, false);

select m.name, count(*)
from meeting_userZ
    left join meeting m on meeting_userZ.id_meeting = m.id
where status_of_participation = true
group by m.name;

select meeting.name, m.count
from meeting left join (select m.name, count(*)
                        from meeting_userZ
                                 left join meeting m on meeting_userZ.id_meeting = m.id
                        group by m.name) m on meeting.name = m.name
where m.count is null;





