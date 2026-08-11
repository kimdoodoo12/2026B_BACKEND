# DB 생성
drop database if exists mydb0811;
create database mydb0811;
use mydb0811;

# 1. 회원 테이블 (member)
create table member(
 mid char(8) not null,   # 식별키 (최대 8자리)
    mname varchar(10) not null,  # 그룹명 (최대 10자리)
    mnumber int not null,   # 인원수
    maddr char(2) not null,   # 지역 (최대 2자리)
    mphone1 char(3),    # 지역번호
    mphone2 char(8),    # 전화번호
    mheight smallint,    # 평균키
 mdebut date,     # 데뷔일 (yyyy-mm-dd)
    constraint primary key (mid)
);

# 2. 구매 테이블 (buy)
create table buy(
 bnum int auto_increment,   # 구매번호 (자동증가)
    mid char(8),     # 구매자 (FK)
    bpname char(6) not null,  # 제품명
    bgname char(4),     # 분류명
    bprice int not null,   # 가격
    bamount smallint not null,  # 구매수량
    constraint primary key(bnum),
    constraint foreign key (mid) references member(mid)
);

# 샘플 데이터
INSERT INTO member VALUES
('TWC','트와이스',9,'서울','02','11111111',167,'2015-10-19'),('BLK','블랙핑크',4,'경남','055','22222222',163,'2016-08-08'),
('WMN','여자친구',6,'경기','031','33333333',166,'2015-01-15'),('OMY','오마이걸',7,'서울',NULL,NULL,160,'2015-04-21'),
('GRL','소녀시대',8,'서울','02','44444444',168,'2007-08-02'),('ITZ','잇지',5,'경남',NULL,NULL,167,'2019-02-12'),
('RED','레드벨벳',4,'경북','054','55555555',161,'2014-08-01'),('APN','에이핑크',6,'경기','031','77777777',164,'2011-02-10'),
('SPC','우주소녀',13,'서울','02','88888888',162,'2016-02-25'),('MMU','마마무',4,'전남','061','99999999',165,'2014-06-19');

INSERT INTO buy VALUES
(NULL,'BLK','지갑',NULL,30,2),(NULL,'BLK','맥북프로','디지털',1000,1),
(NULL,'APN','아이폰','디지털',200,1),(NULL,'MMU','아이폰','디지털',200,5),
(NULL,'BLK','청바지','패션',50,3),(NULL,'MMU','에어팟','디지털',80,10),
(NULL,'GRL','혼공SQL','서적',15,5),(NULL,'APN','혼공SQL','서적',15,2),
(NULL,'APN','청바지','패션',50,1),(NULL,'MMU','지갑',NULL,30,1),
(NULL,'APN','혼공SQL','서적',15,1),(NULL,'MMU','지갑',NULL,30,4);

# 샘플 확인
select * from member;
select * from buy;

# [1] 그룹 절, 그룹당 단 하나의 대표값만 조회
SELECT * from buy;
SELECT * from buy GROUP BY bpname; -- 제품명(bpname)기준으로 그룹하고 모든 필드 조회 [오류]
select bpname from buy GROUP BY bpname; -- 제품명(bpname)기준으로 그룹하고 bpname 필드만 조회

select bpname, mid from buy GROUP BY bpname; -- [오류]

# [2] 기초 집계함수
SELECT sum(bamount) from buy;
select avg(bamount) from buy;
select max(bamount) from buy;
select min(bamount) from buy;
select count(bamount) from buy;

# [3] 그룹절과 집계함수
-- mid 기준으로 그룹하여 총 구매수량
select mid , sum(bamount) as 합계 from buy GROUP BY mid;
-- 2) mid 기준으로 총 구매금액 (수량*가격)
select mid, sum(bamount*bprice) as 총구매금액 from buy GROUP BY mid;

-- 3)mid(회원)별 총 판매 횟수
select count(*) 총판매, mid from buy GROUP BY mid;

# [4] 그룹절의 조건절, where 그룹*전* 조건  [vs] having 그룹 *후* 조건
select * from buy where bamount > 3;

select mid, sum(bamount) 총구매수량 from buy GROUP BY mid HAVING 총구매수량 > 5;
-- where 절에서 필드의 별칭 사용이 안된다. Why? where을 먼저 처리하기 때문에
select mid, sum(bamount) 총구매수량 from buy where 총구매수량 > 5 GROUP BY mid;
# [5] order by 정렬, desc 내림차순(3 2 1, 다 나 가, C B A, 8-11 8-10), asc 오름차순(기본값)
select * from member ORDER BY mdebut;
select * from member order by mdebut desc;

#[*] 다중정렬이란? 첫번째 정렬 후 첫번째 정렬 필드 기준으로 중복이 존재한경우 중복끼리 2차정렬
-- 지역(maddr) 먼저 정렬하고 만약에 지역필드내 동일한 값끼리 2차정렬(mdebut) 한다.
select * from member order by maddr desc, mdebut asc;

# [6] limit: 결과 레코드 제한, *페이징처리*
select * from member; -- 10개
select * from member limit 2; -- 2개
select * from member limit 0, 2; -- 0번부터 2개
select * from member limit 5, 5; -- 5번부터 5개 (5), 활용 1페이지(0부터 5개) 2페이지(0+5, 5개) 2페이지(0+5+5, 5개)

-- [순서] select 필드명 from 테이블명 where 조건절 group by 그룹필드 having 그룹조건 order by 정렬필드 limit 시작인덱스, 개수;