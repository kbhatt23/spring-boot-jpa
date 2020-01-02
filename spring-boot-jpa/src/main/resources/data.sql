create table footballer(
	id integer NOT NULL,
	name varchar(250) NOT NULL,
	birth_date timestamp,
	primary key(id)
);

insert into footballer (id,name,birth_date)
values(1000,'messi',sysdate());


insert into footballer (id,name,birth_date)
values(1001,'hanuman',sysdate());




insert into footballer (id,name,birth_date)
values(1002,'krishna',sysdate());


