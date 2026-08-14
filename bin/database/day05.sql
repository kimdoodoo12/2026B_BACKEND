# 1. 데이터베이스 생성 
drop database if exists mydb0814; -- 만약에 'mydb0814' 데이터베이스 존재하면 삭제
create database mydb0814;   -- 'mydb0814' 데이터베이스 생성 
use mydb0814;      -- 'mydb0814' 데이터베이스 사용 , 워크벤치 재실행후에도
# 2. 테이블 생성 
create table table1(     -- 'table1' 테이블 생성 
 num_pk int ,      -- 'num_pk' 속성/컬럼/필드 을 int 타입 선언 
    constraint primary key( num_pk ) -- 선언된 'num_pk' 속성을 pk(식별키) 설정 
);
# 2. 테이블 생성 
create table table2(
 no_pk int , 
    constraint primary key( no_pk ) ,
    num_fk int ,        -- 'num_fk' 속성 을 int 타입 선언  
    constraint foreign key( num_fk ) references table1( num_pk )   -- 선언된 'num_fk'' 속성을 fk(참조키) 설정 'table1' 테이블의 'num_pk' 를 참조 
    on update cascade  on delete cascade  -- 만약에 table1 의 'num_pk' 값이 수정/삭제 되면 'num_fk' 값도 같이 수정/삭제 
); 
# 3. 서로 다른 테이블 합치기 = JOIN , # PK레코드와 FK레코드를 하나의 테이블로 조회  
# 샘플 데이터 
insert into table1 values( 1 ) , (2) , (3) , (4) , (5);
insert into table2 values( 1 , 1 ) , ( 2 , 2 ) , ( 3 , 1 ) , (4 , 1 ) , (5, 2);
# 레코드 조회 
select * from table1;
select * from table2;

-- table1: 1 , 2 , 3 , 4 , 5
-- table2: 1 1 , 3 1 , 4 1,

# [1] 교집합
# 주의할점 : 두개 이상의 테이블간 데카르트 곱으로 표현
select * from table1 , table2; -- table1(5개) * table2(5개) => 25, 2개이상 테이블 조회
# 1. where
select * from table1 , table2 where table1.num_pk = table2.num_fk; -- 5개
select * from table1 t1, table2 t2 where t1.num_pk = t2.num_fk;
# 2. 테이블 A inner join 테이블B on 조인조건
select * from table1 t1 INNER JOIN table2 t2 on t1.num_pk = t2.num_fk;
# 3. 테이블 A join 테이블B on 조인조건
select * from table1 t1 join table2 t2 on t1.num_pk = t2.num_fk;
# 4. 테이블A Natrual join 테이블B *전제조건: PK와 FK 필드명 같은 경우
-- SELECT * from table1 t1 NATURAL JOIN table2 t2;
# 5. 테이블A JOIN 테이블B USEING(필드명) *전제조건: PK와 FK필드명이 같은 경우
-- select * from table1 t1 join table2 t2 USING(num);
# * 3개 이상 테이블 조인
-- select * from table t1 inner join table t2 inner join table t3 on 조인조건

# OUTER JOIN
# 1. 테이블A LEFT JOIN 테이블B on 조인조건, 왼쪽 테이블에 모든 레코드와 오른쪽 테이블에 교집합 되는 조회
select * from table1 t1 left OUTER join table2 t2 on t1.num_pk = t2.num_fk; -- 8개
# 2. 테이블A RIGHT OUTER JOIN 테이블B ON, 오른쪽 테이블에 모든 레코드
select * from table1 t1 right outer join table2 t2 on t1.num_pk = t2.num_fk; -- 5개
# OUTER 생략가능 (left 또는 right이 있을 경우)
select * from table1 t1 RIGHT join table2 t2 on t1.num_pk = t2.num_fk;

# 합집합, 테이블A UNION 테이블B : 중복 제외한 2개 이상 테이블 합치기, ORACLE: FULL OUTER JOIN
select * from table1 t1 left join table2 t2 on t1.num_pk = t2.num_fk UNION
select * from table1 t1 right join table2 t2 on t1.num_pk = t2.num_fk;

# 차집합, 테이블A LEFT JOIN 테이블B on 조인조건 WHERE 테이블B.FK IS NULL
select * from table1 t1 left JOIN table2 t2 on t1.num_pk = t2.num_fk WHERE num_fk is null;
select * from table1 t1 RIGHT JOIN table2 t2 on t1.num_pk = t2.num_fk WHERE num_pk is null;