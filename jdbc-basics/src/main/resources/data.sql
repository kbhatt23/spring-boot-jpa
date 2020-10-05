create table person(
	id integer not null,
	name varchar(100) not null,
	address varchar(250),
	birth_date timestamp,
	primary key(id)
);

INSERT INTO PERSON (ID,NAME,ADDRESS,BIRTH_DATE)  values(10001,'kanishk','delhi',sysdate());
INSERT INTO PERSON (ID,NAME,ADDRESS,BIRTH_DATE)  values(10002,'keshava','mathura',sysdate());
INSERT INTO PERSON (ID,NAME,ADDRESS,BIRTH_DATE)  values(10003,'raghav','ayodhya',sysdate());
INSERT INTO PERSON (ID,NAME,ADDRESS,BIRTH_DATE)  values(10004,'prabhu','everywhere',sysdate());
INSERT INTO PERSON (ID,NAME,ADDRESS,BIRTH_DATE)  values(10005,'narayan','everywhere',sysdate());

create table personv2(
	id integer not null,
	name varchar(100) not null,
	address varchar(250),
	birth_date timestamp,
	primary key(id)
);

INSERT INTO personv2 (ID,NAME,ADDRESS,BIRTH_DATE)  values(10001,'kanishk','delhi',sysdate());
INSERT INTO personv2 (ID,NAME,ADDRESS,BIRTH_DATE)  values(10002,'keshava','mathura',sysdate());
INSERT INTO personv2 (ID,NAME,ADDRESS,BIRTH_DATE)  values(10003,'raghav','ayodhya',sysdate());
INSERT INTO personv2 (ID,NAME,ADDRESS,BIRTH_DATE)  values(10004,'prabhu','everywhere',sysdate());
INSERT INTO personv2 (ID,NAME,ADDRESS,BIRTH_DATE)  values(10005,'narayan','everywhere',sysdate());