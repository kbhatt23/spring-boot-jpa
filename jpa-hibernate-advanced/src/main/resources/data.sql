INSERT INTO COURSE (ID,course_name,last_modified_date,creation_date)  values(10001,'java masterclass',sysdate(),sysdate());
INSERT INTO COURSE (ID,course_name,last_modified_date,creation_date)  values(10002,'spring masterclass',sysdate(),sysdate());
INSERT INTO COURSE (ID,course_name,last_modified_date,creation_date)  values(10003,'JPA spring hibernate integration',sysdate(),sysdate());




INSERT INTO student (ID,name,last_modified_date,creation_date)  values(20001,'kannu',sysdate(),sysdate());
INSERT INTO student (ID,name,last_modified_date,creation_date)  values(20002,'jagadnath',sysdate(),sysdate());
INSERT INTO student (ID,name,last_modified_date,creation_date)  values(20003,'shambhu',sysdate(),sysdate());

INSERT INTO passport (ID,number,last_modified_date,creation_date,student_id)  values(30001,'AVEPB1881DX1',sysdate(),sysdate(),20001);
INSERT INTO passport (ID,number,last_modified_date,creation_date,student_id)  values(30002,'BVEPB1881DX1',sysdate(),sysdate(),20002);


INSERT INTO review (ID,rating,comment,last_modified_date,creation_date,course_id)  values(30002,4,'great course for beginners',sysdate(),sysdate(),10001);
INSERT INTO review (ID,rating,comment,last_modified_date,creation_date,course_id)  values(30003,5,'wooaw',sysdate(),sysdate(),10001);
INSERT INTO review (ID,rating,comment,last_modified_date,creation_date,course_id)  values(30004,3,'try it out',sysdate(),sysdate(),10003);



INSERT INTO STUDENT_COURSES (students_id,courses_id)  values(20001,10001);
INSERT INTO STUDENT_COURSES (students_id,courses_id)  values(20001,10003);
INSERT INTO STUDENT_COURSES (students_id,courses_id)  values(20003,10001);
 