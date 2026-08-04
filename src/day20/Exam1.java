package day20;

public class Exam1 {
    
    public static void main(String[] args) {
            // 1 객체 만들기
            // 1) 클래스 생성 : 1) .java 새롭게 만들기 20 2) 현재 파일 class{}밖
            // class 클래스명 {상태; 행위;}
            // 2) 클래스 {} 안에서 상태(멤버변수)와 행위(메소드)코드 작성
            // 3) 실행문(Main 함수) 에서 객체 생성: 타입명 변수명 = new 생성자(인수, 인수);
                // 1. class 타입도 참조타입이다.
                // 2. class 타입은 첫글자 대문자, 기본타입 소문자, 변수명 소문자 시작
                // 3. new 인스턴스화: 클래스 기반으로 (heap) 메모리 할당
                // 4. Student 생성자: 클래스명과 동일하며 메소드/함수 동일



        new Student(); // 객체 성
        Student s1 = new Student(); // 객체 생성 후 변수에 저장


        // 객체 사용/참조, .(접근/도트/이동/포인터)연산자 이동하여 멤버 접근
        System.out.println(s1); // 1) 객체 저장하고 있는 변수명 작성, 주소값이 나옴
        
        System.out.println(s1.studentName); // 2) 객체 저장하고 있는 변수명.멤버변수명

        // 객체내 멤버변수 값 수정
        s1.studentName = "유재석";
        s1.studentID = 10;

        Student s2 = new Student();
        Student s3 = new Student();
        Student s4 = s2; // 인스턴스 참조
        s2.studentName = "강호동";
        System.out.println(s2.studentName);
        System.out.println(s4.studentName);

    }

}


class Student{ // 학생 추상 개념 => 코드화
    int studentID; // 클래스안에서 선언된 변수 -> 멤버/인스턴스 변수
    String studentName;


    // 클래스 객체
}


/*
    1. 객체이란? 상태 또는 행위 정의(추상)하는 것
    -> 상태(값/자료), 행위(함수/메서드)
    2. 객체지향 프로그래밍: 개발자(주체)가 컴퓨터내 객체(대상) 만들기
    3. 객체 정의: 클래스(설계도) 기반으로 객체 정의한다.

*/