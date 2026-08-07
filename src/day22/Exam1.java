package day22;

public class Exam1 {
    public static void main(String[] args) {
    /*
        함수란 기능을 수행하는 코드집합
        메소드란? 자바에서는 메소드라고 부른다
        메소드
            1) 클래스 내부 선언
            2) 목적: 재사용, 인수에 따른 서로 다른 결과물/반환
            3) 선언
                반환타입 메소드명( 타입 매개변수 ){
                return 반환값
                }
                - 반환타입: 반환값의 타입/자료형 일치
                - 메소드명: 소문자 시작하는 카멜표기법
                - 타입 매개변수 : 함수호출 하는 곳으로 전달받는 값 타입 일치
                - { } : 함수호출시 실행할 코드
                - return : 함수종료시 반환되는 값
            4) 호출: 다양한 기준
                1. 서로 다른 클래스에서 메소드 호출시 인스턴스(객체) 필요
                    주체: this(특정 메소드/생성자 호출한 객체)
                    객체변수명.메소드명();
                2. 동일한 클래스 내 메소드 호출시 인스턴스 필요없다.
                    메소드명();
                ** 매개변수는 지역변수이다
                    지역변수란? 특정함수/if/for{} 에서 선언된 변수는 종료되면 사라진다. {} 밖에서 호출이 안된다.
                
     */
    Calculator calc = new Calculator();
    System.out.println(calc.getPI());  

    calc.powerOn();
    calc.printSum(3, 5);
    System.out.println(calc.add(3, 5));

    }
}

class Calculator{
    // 1. 멤버변수
    // 2. 생성자 
    // 3. 메소드/함수
    // 1) 매개변수 X 반환값 O
    double getPI(){
        return 3.14;
    }
    void powerOn(){
        System.out.println("ON");
    }
    void printSum(int x, int y){
        System.out.println(x + y);
    }
    int add (int x, int y){
        return x + y;
    }
}

class personType{
    String name;
    int age;
    String job;

    // 사람이 태어날 때 초기로 가져야할 설계 = 생성자
    personType(String name){
        this.name = name;
        age = 1;
    }

    void getHired(String jobName){
        this.job = jobName;
        return;
    }
}