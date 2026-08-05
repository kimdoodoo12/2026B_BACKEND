
-- 현재 

# 한줄 주석
-- 한줄 주석
/* 전체 주석 */

-- 데이터베이스란? 여러 데이터들을 집합/공간
-- 데이터베이스 서버란? 여러 데이터베이스들을 저장한 PC/프로그램(MYSQL)

-- 1 SQL 문법;
-- 실행할 SQL 문법에 커서 두고 Run 클릭 또는 Ctrl + Enter
SHOW DATABASES; -- 연결된 DB 서버 내 모든 데이터베이스 목록 확인

-- 2 데이터베이스 로컬 경로
SHOW VARIABLES LIKE 'datadir';

-- 3 데이터베이스 생성, SQL 문법은 대소문자 구분하지 않는다.
CREATE DATABASE mydb0804; -- 연결된 DB 서버 내 특정한 데이터베이스 생성

DELETE DATABASE mydb0804; --

-- 4 데이터베이스 삭제, if exists 존재하면 삭제, 없는 데이터베이스는 삭제 불가능
DROP DATABASE mydb0804;

DROP DATABASE IF EXISTS mydb0804;

-- 5. 데이터베이스 활성화: 연결된 DB서버 내 여러 개 DB중 조작할 DB 선택
USE mydb0804;


-- 활용 : 프로젝트 데이터베이스 초기화한다.
DROP DATABASE IF EXISTS boardService;

CREATE DATABASE boardService;

USE boardService;