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

insert into passport (id,passport_number)
values(5000,'EXPA1223');

insert into passport (id,passport_number)
values(5001,'EXPA1224');

insert into student (id,student_name,passport_id)
values(7000,'kanishk',5000);

insert into student (id,student_name,passport_id)
values(6999,'ricardo',5001);






