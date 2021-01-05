create table applications.public.role (
                                          id serial primary key,
                                          name varchar(200)
);

create table applications.public.rules (
                                           id serial primary key,
                                           name varchar(200),
                                           creates boolean,
                                           reads boolean,
                                           updates boolean,
                                           deletes boolean
);

create table applications.public.role_rules (
                                                id serial primary key,
                                                role_id int references role(id),
                                                rules_id int references rules(id)
);
--вспомогательная теблица | role - rules = many-to-many

create table applications.public.users (
                                           id serial primary key,
                                           name varchar(1000),
                                           role_id int references role(id),
                                           role_rules int references role_rules(id)
);

create table applications.public.comments (
                                              id serial primary key,
                                              name varchar(5000)
);

create table applications.public.attachs (
                                             id serial primary key,
                                             name varchar(2000)
);

create table applications.public.category (
                                              id serial primary key,
                                              name varchar(2000)
);

create table applications.public.state (
                                           id serial primary key,
                                           name varchar(2000)
);

create table applications.public.item (
                                          id serial primary key,
                                          name varchar(2000),
                                          users_id int references users(id), --many-to-one
                                          category_id int references category(id), -- many-to-one
                                          state_id int references  state(id) --many-to-one
);

create table applications.public.item_comments (
                                                   id serial primary key,
                                                   item_id int references item(id),
                                                   comments_id int references comments(id)
);
--вспомогательная теблица | item - comments = one-to-many

create table applications.public.item_attachs (
                                                  id serial primary key,
                                                  item_id int references item(id),
                                                  attachs_id int references attachs(id)
);
--вспомогательная теблица | item - attachs = one-to-many