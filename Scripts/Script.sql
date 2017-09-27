show databases;

create table student(
	id char(7),
	name varchar(10),
	dept varchar(20),
	primary key(id)
);
show tables;
desc student;

insert into student values('1091011', '김철수', '컴퓨터시스템'),
							('0792012', '최고봉', '멀티미디어'),
							('0494013', '이기자', '컴퓨터공학');
-- insert into student values('0792012', '최고봉', '멀티미디어');							
select * from student;

update student set dept='컴퓨처공학' where id='0792012';

delete from student where name='배수지';

insert into student values('1234567','배수지','성악과');






















