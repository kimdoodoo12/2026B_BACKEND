package day23;

import day23.package1.A;

public class Exam1 {
    public static void main(String[] args) {
        /*
            접근제한자 : 클래스, 멤버변수, 메소드, 생성자 등 호출 (폴더/클래스) 제한 만들기
                1) 종류
                    1. public   : 공개, 프로젝트 내 어디서든 호출/사용 가능
                    2. private  : 비공개, 현재 클래스 내에서만 호출/사용 가능
                    3. (default): (생략시), 같은 패키지 내 호출/사용 가능
                    4. protected: 같은 패키지(폴더)내 호출/사용 가능 (*상속 관계 에외(다른 패키지 가능)*)
                2) 사용법 : 선언 타입 옆에 작성
                    1. 접근제한 class 클래스명{ }
                    2. 접근제한자 타입 멤버변수
                    3. 접근제한자 생성자명{   }
                    4. 접근제한자 반환타입 메소드명(){ }
                3) 목적 : 캡슐화(실질적인 정보의 접근을 제한하고 감싼다), 대규모 프로젝트에서 또는 특정인원들의 사용범위를 정하기 위해서
                -> 관례적으로 클래스 내 멤버변수(자료)는 private하고 접근하기 위한 간접적인 메소드(getter/setter)를 제공
         */

        // [1] 접근 제한된 변수
        A a = new A();
        a.publicVar = 3;
        // a.privateVar = 3; // private이라서 불가능
        // a.generalVar = 3; // 다른 패키지(폴더) 불가능

        a.publicFunc();
        // a.privateFunc();
        // a.generalFunc();

        // [3] 비공개된 생성자로 객체 생성 안된다.
        // B b = new B();
    }
}
