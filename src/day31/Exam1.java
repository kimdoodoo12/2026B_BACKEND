package day31;

public class Exam1 {
    /*
        스레드: 코드 실행 흐름 단위
        멀티스레드: 여러 사용자들이 하나의 웹서버(톰캣)에 요청함으로 웹서버는 멀티스레드로 관리
        장점: 여러 요청들을 다중처리 , 단점 관리(동기화/과부화)
        1. 동기화 vs 비동기화
            동기화 : LOCK(대기)상태 이용하여 단 하나의 스레드가 메소드 점유
                - 무결성 보장, 순서대로 처리해야 되는 경우
            비동기화 : 여러 스레드가 하나의 메소드 같이 점유
                - 무결성 보장없음, 순서가 없는 경우
     */

    public static void main(String[] args) {
    Calculator calculator = new Calculator();
    
    Thread1 thread1 = new Thread1();
    thread1.calculator = calculator;
    Thread2 thread2 = new Thread2();
    thread2.calculator2 = calculator;
    
    thread1.start();
    thread2.start();
    }


    
    
}


class Calculator {  // 클래스란? 인스턴스 설계도 (종이)
    // 멤버변수란? 인스턴스의 상태/변수/값저장소/필드/속성/key , 인스턴스마다
    public int memory;
    // 메소드란? 인스턴스의 행위/이벤트

    //[1] 비동기화(기본값)      :: 200 200 출력
    public void setMemory1(int memory){
        this.memory = memory;
        // super란? 부모의 메소드/멤버변수 가리킴
        // 2~3초 대기상태 만들기
        try{Thread.sleep(2000);}catch(Exception e){}
        System.out.println("현재계산기의 값: " + this.memory);
    }

    // [2] 동기화 (synchronized)    : 100(두번째 요청이 대기상태), 200 출력
    public synchronized void setMemory2(int memory){

        this.memory = memory;
        try{Thread.sleep(2000);}catch(Exception e){}
        System.out.println("현재계산기의 값: " + this.memory);
    }
}

class Thread1 extends Thread{
    public Calculator calculator;
    @Override
    public void run() {
        calculator.setMemory1(100);  // 계산기 메소드에 100 대입
        }
}
class Thread2 extends Thread{
    public Calculator calculator2;
    @Override
    public void run() {
        calculator2.setMemory1(200); // 계산기 메소드에 200 대입
    }
}