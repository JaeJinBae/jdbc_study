show databases;

create table student(
	id char(7),
	name varchar(10),
	dept varchar(20),
	primary key(id)
);
show tables;
desc student;

insert into student values('1091011', '��ö��', '��ǻ�ͽý���'),
							('0792012', '�ְ��', '��Ƽ�̵��'),
							('0494013', '�̱���', '��ǻ�Ͱ���');
-- insert into student values('0792012', '�ְ��', '��Ƽ�̵��');							
select * from student;

update student set dept='��ǻó����' where id='0792012';

delete from student where name='�����';

insert into student values('1234567','�����','���ǰ�');






















