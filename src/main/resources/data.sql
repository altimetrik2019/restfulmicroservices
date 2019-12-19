insert into users(id, name, birthdate) values(1, 'ABCD', sysdate());
insert into users(id, name, birthdate) values(2, 'BCDE', sysdate());
insert into users(id, name, birthdate) values(3, 'CDEF', sysdate());
insert into posts(id, description, user_id) values(1, 'My First Post', 1);
insert into posts(id, description, user_id) values(2, 'My Second Post', 1);
insert into posts(id, description, user_id) values(3, 'My First Post', 2);