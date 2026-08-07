
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

-- insert into test(name) values("유재석"); -- 이름(unique)은 중복 불가능 / 오류

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

# SQL 연산자
# 1. 회원테이블
create table member(    # 아이돌 그룹
 mid char(8) not null ,   # 식별키   최대 8자리
    mname varchar(10) not null , # 그룹명  최대 10자리
    mnumber int not null ,   # 인원수  정수 +-21억정도
    maddr char(2) not null ,   # 지역  최대 2자리
    mphone1 char(3) ,    # 지역번호 최대 2자리
    mphone2 char(8) ,    # 전화번호  최대 8자리
    mheight smallint ,    # 평균키   정수 +-3만정도
 mdebut date ,     # 데뷔일   yyyy-mm-dd
    constraint primary key ( mid )    # 제약조건
);
# 2. 구매테이블
create table buy(
 bnum int auto_increment ,    # 구매번호 정수  자동번호 부여
    mid char(8),      # 구매자  FK
    bpname char(6) not null ,   # 제품명  최대 6자리
    bgname char(4) ,      # 분류명   최대 4자리
    bprice int not null ,    # 가격   정수
    bamount smallint not null ,   # 구매수량 정수
    constraint primary key(bnum) ,     # 제약조건
    constraint foreign key ( mid ) references member(mid) # 제약조건
);
# 샘플데이터
INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '061', '99999999', 165, '2014.06.19');
INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '아이폰', '디지털', 200, 5);
INSERT INTO buy VALUES(NULL, 'BLK', '청바지', '패션', 50, 3);
INSERT INTO buy VALUES(NULL, 'MMU', '에어팟', '디지털', 80, 10);
INSERT INTO buy VALUES(NULL, 'GRL', '혼공SQL', '서적', 15, 5);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 2);
INSERT INTO buy VALUES(NULL, 'APN', '청바지', '패션', 50, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 1);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 4);


# [1] as 별칭 키워드, 조회 결과의 속성명 변경, as 생략하고 띄어쓰기 사용가능

select mid from member -- member 테이블의 mid 속성 레코드 조회

select mid as 회원아이디 from member -- 조회 결과 mid 속성명을 회원아이디 별칭

select mid as 회원아이디 from member as 회원테이블; -- SQL내 속성명/테이블명 별칭

select mid 회원아이디 from member 회원테이블; -- as 생략하고 띄어쓰기 별칭


# [2] distinct, 조회 결과의 속성값 중복 제거
select DISTINCT maddr from member;

# [3] 산술연산자 : +더하기 -빼기 /나누기 *곱하기 div몫 mod나머지
select mnumber 인원수, mnumber+3 더하기, mnumber-3 빼기, mnumber/3 나누기,
 mnumber*3 곱하기, mnumber div 3 몫, mnumber mod 3 나머지 from member;

select * from member;

# [4] 비교연산자 : =같다 !=같지않다 >초과 <미만 >=이상 <=이하
# [5] 논리연산자: and이면서 or이거나 not부정
select * from member where mname = "블랙핑크";

select * from member where mnumber = 4;

select * from member where mname != "블랙핑크";

select * from member where not mname = "블랭핑크"; -- 블랭핑크이면 반대

select * from member where mheight <= 162;  -- height 속성값이 162이하이면

select * from member where mheight >= 165 and mheight <= 170;

select * from member where mheight BETWEEN 165 and 170; -- 속성명 between 시작값 and 끝값

select * from member where maddr = "경기" or maddr = "전남" or maddr = "경남" -- 지역 속성값이 3개중 하나라면

select * from member where maddr IN("경기", "전남", "경남"); -- 속성명 in(값1, 값2, 값3)

select * from member where mphone1 = null; -- 데이터베이스에서 null 처리 방법

select * from member where mphone1 is null; -- 주의할점 : =null[x] 대신에 is null[0]

-- 문자열 패턴 : 속성명 like "문자패턴" , % : 모든 문자대응 , _:개수만큼 문자대응

select * from member where mname like "에이%";  -- 에이로 시작하는 모든 문자
select *from member where mname like "에이_"; -- 에이로 시작하는 3글자
select * from member where mname like "%이%"; -- '이'가 포함된 모든 문자
select * from member where mname like "_이__" -- 두번째 글자가 '이'인 4글자