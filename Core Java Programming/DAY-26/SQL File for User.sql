create database wipro_training;
use wipro_training;
create table sume(
ID int ,
Sname varchar(100),
email varchar(100));
insert into sume(ID, Sname, email) values(1, 'khalfan','khalfan@gmail.com');
insert into sume(ID, Sname, email) values(2, 'shabrin','shabrin@gmail.com');
select * from sume;
truncate sume;
describe sume;
delete from sume where ID=4;
drop table sume;
