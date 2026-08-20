package day28;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import day24.종합예제.model.dto.BoardDto;

class Exam1{
    public static void main(String[] args) {
        // 라이브러리
        // [1] Object 클래스 : 자바의 최상위 클래스 *다형성*

        Object o1 = 3;  Object o2 = 3.14;   Object o3 = "유재석";
        Object o4 = true;   Object o5 = new int[3];
        // 모든 자료들은 Object 타입 변수에 대입 가능
        // 1. toString() : 객체의 주소값 반환 함수, 즉 생략 가능
        System.out.println(o5.toString());
        System.out.println(o5);
        Object o6 = new BoardDto();
        System.out.println(o6.toString());  // toString()에 대한 오버라이딩
        System.out.println(o6);

        Object o7 = new BoardDto();
        System.out.println(o6 == o7);
        System.out.println(o6.equals(o7));

        String str1 = "유재석"; String str2 = new String("유재석");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        System.out.println(str1 == "유재석");
        System.out.println(str2 == "유재석");
        System.out.println(str2.equals("유재석"));
        // 3. hashCode () : 객체를 식별하는 값을 정수로 반환 함수. 주소값은 16진수
        // 활용처: 객체 탐지하는 경우에 주소값이 아닌 정소로된 값(키) 비교하여 속도 향상
        System.out.println(o6.hashCode());
        System.out.println(o7.hashCode());
        System.out.println(str1.hashCode());
        System.out.println("유재석".hashCode());

        // [2] Class : 클래스의 정보(멤버변수/메소드/생성자) 담는 클래스
        // 1. getClass()
        String obj1 = new String(); Class c1 = obj1.getClass();
        System.out.println(c1);
        // 2. Class.forName("패지지명.클래스명"),
        // *** 리플렉션 *** : 최초실행(컴파일)할 때 해당 클래스의 객체를 로드/생성 하지 않고 실행 도중에 객체 로드/생성한다.
        // 활용처: JDBC(프로그램 시작이 아닌 DB 연동시 MYSQL관련 클래스로드), 스프링프레임워크(Ioc)
        try{ Class.forName("java.lang.String"); 
        }catch (Exception e){System.out.println("연동실패 " + e);}

        // 3. getFields() : 클래스내 멤버변수 정보 반환
        Field[ ] fields = c1.getFields();
        for (Field field : fields){System.out.println(field);}

        // 4. getConstructors() : 클래스내 생성자 정보 반환
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor: constructors){
            System.out.println(constructor);
        }
        // 5. getMethods(): 클래스 내 메소드 정보 반환
        Method[] methods = c1.getMethods();
        for (Method method : methods){System.out.println(method);}

    }
}