

drop database if exists mydb0805; # [1] 데이터베이스 삭제

create database mydb0805; # [2] 데이테베이스 생성

show databases; # [4] 데이터베이스 목록

use mydb0805; # [4] 데이터베이스 서버에는 여러 개 데이터베이스 존재하므로 특정 DB를 선택해야 함


# --------------------------------------------------------------------- #
# DDL: 데이터베이스/ 테이블 생성 / 삭제 / 수정 질의어 (auto commit) / 트랜잭션 불가능
# 1) 테이블 생성 : 1. 테이블을 생성할 테이베이스 활성화 
create table test1( 필드명1 int , 필드명2 double, 필드명3 text);

# 2) 테이블 목록 조회
show tables;
# 3) 특정 테이블의 속성 확인
DESCRIBE test1;
alter table test1 add 필드명4 float;
# 4) 필드/속성 수정
alter table test1 modify 필드명3 longtext;
# 5) 필드/속성명, 타입 수정
alter table test1 change 필드명1 필드명5 bigint;
# 6) 테이블 이름 변경
rename table test1 to new_test1;

# 7) 테이블 내 모든 레코드(행/데이터) 삭제
truncate table new_test1; # vs delete

# 테이블의 속성/필드 타입 "DBMS 회사마다 차이"

use mydb0805;

create table test2(
    정수필드1 tinyint, 정수필드2 smallint, 정수필드3 mediumint, 정수필드4 int, 정수필드5 bigint, 정수필드6 int unsigned,
    -- UNSIGNED 부호없음. tinyint(1바이트 -127 ~ 128) --> 0~225

    실수필드1 float, 실수필드2 double, 실수필드3 decimal,
    -- decimal 문자타입이면서 소수점 오차 없음
    날짜필드 date, 시간필드 time, 날짜시간필드 datetime,
    문자필드1 char(3), 문자필드2 varchar(3),
    -- char(문자 고정길이), varchar(문자가변길이)
    -- [수][박][x], [수][박]
    -- 사진이 포함된 게시물내용 저장시 : 4GB까지 가능한 longtext 권장
    논리필드 boolean -- boolean -> tinyint 마지막 필드타입 뒤로 , 넣으면 X
);

describe test2;

# ----------------------------------------------------------------------------------- #
# 속성/필드 제약조건

create table test3(
    필드명1 tinyint not NULL,   -- 해당 필드/속성에는 null 저장할수 없음
    필드명2 smallint unique,    -- 해당 필드/속성에는 중복값을 저장할 수 없도록 설정
    필드명3 int default 100,    -- 해당 필드/속성에는 레코드(행) 생성 시 기본값 100이 대입
    필드명4 datetime default now(), -- 레코드 삽입시 현재날짜/시간 자동 대입
    필드명5 bigint auto_increment,
    constraint primary key(필드명5) -- 특정 필드/속성 pk로 설정한다.  
    -- auto_increment: 해당 필드/속성에 레코드(행) 삽입시 자동으로 순서번호 설정, 1 2 3 4
    -- primary key(PK): 기본/식별 키, 식별 가능한 고유한 값을 갖는 필드 (not null + unique 내장됨)
    -- foreign key(FK): 참조/외래 키 (PK가 다른 테이블에 위치한 경우), 다른 테이블의 기본키를 참조하는 키
        -- 수강신청학번, 급여지급사번, 판매코드 등
        -- 참조옵션: PK가 삭제/수정된 경우 FK 어떻게?
            -- on delete/update cascade : pk가 삭제/수정되면 fk도 같이 삭제 수정
            -- on delete/update set null : pk가 삭제/수정되면 fk은 null로 수정
            -- on delete/update restrict : (생략시 기본값) pk가 fk로부터 참조중이면 삭제/수정 불가능
);

create table test4(
    필드명1 bigint,
    constraint foreign key (필드명1) references test3(필드명5) on delete cascade on update cascade
);
--mysql workbench (ERD 다이어그램 자동생성)

# 예제1 회원제 게시판 ----------------------------------------------------------------- #
# 1) 데이터베이스 생성한다
drop database if exists boardService0805;
create database boardService0805;

use boardService0805; # 3) 데이터비이스 활성한다

create table member( # 4) 회원 테이블 생성한다
    mno int AUTO_INCREMENT, -- 자동 회원번호
    constraint primary key(mno), -- 회원번호를 PK로 설정
    mid varchar(30) not null unique, -- 회원아이디면서 최대 30글자, 공백 불가능, 중복불가능 설정
    mpwd varchar(20) not null, -- 회원비밀번호이면서 최대 20글자, 공백 불가능, 중복 가능 설정
    mname varchar(10) not null, -- 회원닉네임
    mdate datetime default now() -- 회원가입 날짜/시간
    -- 레코드삽입시간, 수정날짜/시간은 관례적으로 유지보수를 위해 넣기도 한다.
);

create table board ( -- 5) 게시물 테이블 생성한다.
    bno int AUTO_INCREMENT,
    constraint primary key(bno), -- 게시물번호 pk 설정, 테이블 1개당 pk 1개 이상 권장
    btitle varchar(255), -- 게시물 제목
    bcontent longtext, -- 게시물 내용, 대용량(사진)포함 최대 4G까지
    bdate datetime default now(), -- 게시물 작성일
    bview int DEFAULT 0, -- 게시물 조회수
    mno int, -- 작성자(mid가 아니고 mno), 관례적으로 PK-FK 필드명 동일
    constraint foreign key(mno) REFERENCES member (mno) on delete cascade
);