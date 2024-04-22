create table students(
    Id int auto_increment primary key,
    studentName varchar(20),
    Dob date,
    mobile bigint,
    courseId int
);

    insert into students(studentName,Dob,mobile)
    values('john','2002-07-12',9949260690);

create table course(
    courseId int auto_increment primary key,
    courseName varchar(20)
);
insert into course(courseName)
values('java');

create table teacher(
    teacherid int auto_increment primary key,
    teacherName varchar(30)
);