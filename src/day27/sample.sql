-- day12 Exam2 연동

CREATE DATABASE mydb0813;

use mydb0813;

CREATE Table test(
    no int AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(10)
);

 
 	
CREATE DATABASE mydb0813;
USE mydb0813;
CREATE TABLE board( 
    no int AUTO_INCREMENT , 
    content VARCHAR(255) ,
    writer VARCHAR(30) ,
    constraint PRIMARY KEY( no ) 
);
insert into board( content, writer )values( "안녕하세요", "유재석" ),( "하하", "강호동"); -- 샘플 데이터 2개 