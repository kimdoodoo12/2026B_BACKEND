package day21;

public class Exam1 {
    public static void main(String[] args) {
        /*
        생성자: 인스턴스(객체) 생성할 때 사용되는 키워드
        선언하는 방법
            1) 클래스 내부
            2) 클래스명과 동일
            3) 오버로딩 지원: 동일한 이름으로 여러개 선언, 조건
        목적: 1) 빠른 초기화 2) 객체 생성 규칙/유효성 검사
        종류: 2) 기본 생성자(매개변수 X) 2) 정의생성자 (매개변수 O)
         */

        // [1] 기본 생성자로 객체 생성, new 생성자명()
        Phone p1 = new Phone();
        
        p1.model = "galaxy"; // 객체내 멤버변수 초기화

        // [2] 정의한 생성자로 객체 생성, new 생성자명(값1, 값2)
        Phone p2 = new Phone("iphone", "blue");

        // [3] 정의생성자로 객체 생성
        Phone p3 = new Phone("xiaomi", "black", 10000);

    }
}

class Phone{
    // *** 클래스 가족(멤버들) ***
    // 1. 멤버 변수
    String model;
    String color;
    int price;

    // 2. 생성자
    // 생성자가 1개도 없으면 자동으로 기본 생성자가 생성
    // 생성자명은 중복이 안된다. 그러나 *오버로딩*은 가능하다.
    // 매개변수 개수/타입/순서 다르면 다른 생성자로서 작동이 된다.
    // this란? 매개변수명과 멤버변수명 같은 경우 멤버변수명 앞에 this
    // 매개변수와 인자값의 타입/개수 일치!!
    // 메소드와 다르게 생성자는 리턴이 없다 (생성된 객체주소값)
    // 1) 기본생성자 : 매개변수가 없는
    Phone() {}
    
    // 2) 정의 생성자: 매겨변수가 있는
    Phone(String model, String color){
        this.model = model;
        this.color = color;
    }

    // 3)
    Phone(String model, String color, int price){
        this.model = model;
        this.color = color;
        this.price = price;
    }

    // 3. 메소드/함수


}