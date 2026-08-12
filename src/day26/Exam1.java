package day26;

public class Exam1 {
    /*
        기본타입(리터럴): (8) byte, short, int, long, float, double, char, boolean
        참조타입(객체): [] 배열, 클래스(String, Dto, Scanner 등등), 인터페이스
     */
    // 1. 인터페이스 만들기, interface 인터페이스명
    // 2. 인터페이스 주요멤버: 상수, 추상메소드(public abstract)
    // 3. 추상메소드 구현할 클래스 필요<구현객체> , 클래스명 implements 인터페이스명, 인터페이스명

    public static void main(String[] args) {
        // [1] 인터페이스로 인스턴스 생성불가능
        // 생성자가 존재하지 않음
        // Exam1InterFace ei = new Exam1InterFace();

        // [2] implements 구현한 객체
        ExamClass ec = new ExamClass();
        ec.method1(10); // 가능
        ec.method2(10, 20); // 가능

        // [3] 다형성: 업캐스팅
        Exam1InterFace ei = new ExamClass();
        // 인터페이스 타입이더라도 오버라이딩 우선!!
        ei.method1(10); // 가능
        ei.method2(10, 20); // 가능
    }
}

interface Exam1InterFace{
    int a = 10; // 상수! 인터페이스에서는 public static 생략해도 상수이다.
    public static final int b = 20;
    // *생성자 없다. 즉 new 없다 --> 인스턴스 불가능, 목적: 여러 인스턴스 호환/관리
    // *추상메소드: 선언부만 존재하고 { } 구현부가 없는 메소드
    void method1(int x);
    public abstract int method2(int x, int y);
}

class ExamClass implements Exam1InterFace{ // 해당 클래스가 지정한 인터페이스 구현
    // * 상속은 오버라이딩(선택) vs 구현은 오버라이딩(필수)
    // 구현 모두 마치면 클래스에 오류 사라짐
    // 자동 완성:
    @Override public void method1(int x) {System.out.println(x);}
    @Override public int method2(int x, int y) { return x + y ;}
}

