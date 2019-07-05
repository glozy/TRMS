create table user_trms(
employeeid serial primary key,
username varchar unique not null,
password varchar not null,
employeetype varchar not null,
firstname varchar not null,
lastname varchar not null,
email varchar,
phone varchar,
pending numeric(10,2) default 0.0,
award numeric(10,2) default 0.0,
available numeric(10,2) default 1000.0
);

create table reimbursement_trms(
formid serial primary key,
employeeid integer references user_trms (userid),
startdate date,
enddate date,
status varchar,
form_time time default current_time,
address_location varchar(50),
description varchar (200),
course_cost numeric(10,2),
grading_format varchar(50),
events varchar(50),
work_justify varchar(200),
event_attachments text,
grade varchar
);

insert into user_trms values (default, 'cedric', '123', 'HOD', 'Zach', 'Greg', 'zachgreg@revature.co', '2547895214', null);
insert into user_trms values (default, 'paul', '123', 'BENCO', 'Paul', 'Timothy', 'paultimothy@revature.co', '2145895214', null);
insert into user_trms values (default, 'ken', '123', 'supervisor', 'Phil', 'Kenny', 'philkenny@revature.co', '2547311214', null);
insert into user_trms values (default, 'paul', '123', 'associate', 'Luke', 'Graham', 'lukegraham@revature.co', '2102595214', null);
insert into user_trms values (default, 'ryan', '123', 'associate', 'Ryan', 'Pum', 'ryanpum@revature.co', '2106525214', null);


select * from user_trms;
select * from reimbursement_trms;
