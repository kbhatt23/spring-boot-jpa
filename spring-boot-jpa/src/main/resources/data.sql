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

insert into course (course_id,course_name,creation_date,last_modified_date)
values(4000,'spring boot',sysdate(),sysdate());

insert into course (course_id,course_name,creation_date,last_modified_date)
values(4001,'spring cloud',sysdate(),sysdate());

insert into review (id,rating,comment,course_id)
values(3000,'5','One of the Best course available online' ,4000 );

insert into review (id,rating,comment,course_id)
values(3001,'4','Great for beginners but not enough for experts' ,4000 );

insert into course_student_join_table (course_join_id,student_join_id)
values(4000,6999 );
insert into course_student_join_table (course_join_id,student_join_id)
values(4000,7000 );
insert into course_student_join_table (course_join_id,student_join_id)
values(4001,6999 );
insert into course_student_join_table (course_join_id,student_join_id)
values(4001,7000 );









