package day27;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exam2 {
    public static void main(String[] args) {
        // JDBC란? 자바와 데이터베이스 연동 제공하는 인터페이스
        // 1. 프로젝트내 lib 폴더에 jdbc관련.jar파일을 저장한다.
        // 연동
        // [1] MYSQL 회사에서 제공하는 Driver 구현체 (동적) 로드, 리플렉션 *예외처리 필수*
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver 연동성공");
        // [2] 데이터베이스 서버 연동 * 예외처리 필수 *
        // DriverManager.getConnection("jdbc:mysql://(ip번호)localhost:3306/", "계정명", "비밀번호");
            String url = "jdbc:mysql://127.0.0.1:3306/mydb0813";
            String user = "root"; String password = "1234";
            Connection conn = DriverManager.getConnection(url, user, password);

            System.out.println("데이터베이스 연동성공");

            //[3] 연동된 데이터베이스 내 DML (insert, select, update, delete)조작
            // 1. insert하기 insert into test 테이블명(필드명)
            String sql = "insert into test(name) values ('유재석')";
             
            PreparedStatement ps = conn.prepareStatement(sql);
            // conn(연동된 인터페이스).prepareStatement(기재할 SQL); 기재된 인터페이스 반환
            // PreparedStatement (SQL이 개지된 인터페이스);
            int result = ps.executeUpdate(); // ps(SQL기재된 인터페이스 SQL 실행)
            System.out.println(result); // 1: 성공, 0: 실패
            System.out.println("레코드 등록 성공");

            // 2. select 하기, select 필드명 from 테이블명;
            String sql2 = "select * from test";
            ps = conn.prepareStatement(sql2); // 작성한 SQL 기재한다
            ResultSet rs = ps.executeQuery(); // 기재된 SQL 실행, 결과를 rs 인터페이스 대입
            rs.next(); // 조회결과 다음레코드로 이동
            System.out.println(rs.getInt("no")); // rs.get타입("속성명")
            System.out.println(rs.getString("name"));


        }catch(ClassNotFoundException e){
            System.out.println("드라이버가 존재하지 않습니다." + e);
        }catch(SQLException e){
            System.out.println("DB서버와 연동실패" +  e);
        }

        
    }
}
