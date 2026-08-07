
drop DATABASE if EXISTS mydb0807;

create database mydb0807;

use mydb0807;   -- ctrl + shift + enter : 전체 실행, ctrl + enter : 한줄실행

create table test( -- create table 테이블명 (속성명 타입 , 속석명 타입)
    no int AUTO_INCREMENT ,
    constraint primary key( no ),
    name varchar(30) not null UNIQUE,
    count int DEFAULT 2
);

-- DML : 조작어 , 1) insert 레코드 삽입 2) select 레코드조회 3) update 레코드ㅅ줭 4) delete 레코드삭제
-- 레코드란? 테이블 내 행/가로 단위
# [1] insert : insert into 테이블명 (속성명 1, 속성명2) values (값1, 값2)
insert into test(no, name, count) VALUES (1, "유재석", 10);
INSERT into test(name, count) VALUES ("강호동", 20); -- 번호 값 제외한 삽입

insert into test(name) VALUES("신동엽"); -- 번호(auto), 개수(default) 제외한 삽입

insert into test(name) values("유재석"); -- 이름(unique)은 중복 불가능 / 오류

insert into test VALUES(4, "하하", 30); -- 모든 속성값 순서대로 값 대입식 속성명 생략

INSERT into test(name) values("박명수"), ("수박"), ("바나나");

# [2] select: select *[*전체/속성명] from 테이블명 where 조건
select * from test; -- 테이블 내 모든 속성의 레코드 조회
select name from test;  -- 테이블 내 '이름' 속성명의 레코드 조회
select name, count from test; -- '이름' '개수' 속성명의 레코드 조회

select * from test where name = "유재석";
select * from test where count >= 5;


# [3] update : update 테이블명 set 속성명 = 새로운 값, 속성명 = 새로운 값 where [조건]

update test set count = 20; -- 조건이 없으므로 테이블 내 '개수' 속성들의 값 모두 10으로 수정

update test set count = 30 where name = "유재석";   -- 이름 속성값이 유재석이면 속성값을 30으로 수정

update test set count = 40, name = "강호동2" where no = 2; -- 번호 속성값이 2인 개수속성값을 40과 이름은 강호동 2수정

DELETE from test where name = '유재석';

DELETE from test where no = 2;

-- (DML) delete : 테이블 내 레코드 삭제 [vs] (DDL) truncate table: 테이블내 레코드 삭제 [vs] drop table: 테이블 전체삭제
-- DDL은 취소 불가능, DML 취소(ROLLBACK rksmd)