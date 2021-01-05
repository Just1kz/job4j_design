insert into applications.public.role(name) VALUES ('Admin');
insert into applications.public.role(name) VALUES ('Main_workers');
insert into applications.public.role(name) VALUES ('Middle_workers');
insert into applications.public.role(name) VALUES ('Low_workers');
insert into applications.public.rules(name, creates, reads, updates, deletes) VALUES
('Admin', true, true, true, true);
insert into applications.public.rules(name, creates, reads, updates, deletes) VALUES
('Main_workers', true, true, true, false);
insert into applications.public.rules(name, creates, reads, updates, deletes) VALUES
('Middle_workers', true, true, false, false);
insert into applications.public.rules(name, creates, reads, updates, deletes) VALUES
('Low_workers', false, true, false, false);
insert into applications.public.role_rules(role_id, rules_id) VALUES (1, 1);
insert into applications.public.role_rules(role_id, rules_id) VALUES (2, 2);
insert into applications.public.role_rules(role_id, rules_id) VALUES (3, 3);
insert into applications.public.role_rules(role_id, rules_id) VALUES (4, 4);

insert into applications.public.users(name, role_id, role_rules) VALUES ('Anton', 3, 2);

select
    t.name as NAME_USER,
    r2.name as NAME_ROLE,
    r2.creates as RULES_CREATE,
    r2.reads as RULES_READ,
    r2.updates as RULES_UPDATE,
    r2.deletes as RULES_DELETE
from applications.public.users t
left join rules r2 on r2.id = t.role_rules
