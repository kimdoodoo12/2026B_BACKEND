package day25;

public class Exam3 {
    public static void main(String[] args) {
/*
        오버로딩: 생성자/메소드명 동일하게 여러개 선언
            조건: 매개변수 개수, 타입, 순서 다른 경우
        오버라이딩: 상속관계에서 물려받은 메소드를 재정의
 */
        // 1. 상위객체
        상위클래스 obj1 = new 상위클래스();
        obj1.show();
        System.out.println(obj1.value1);
        // System.out.println(obj1.value3);

        // 2. 하위객체
        하위클래스 obj2 = new 하위클래스();
        obj2.show(10);
        obj2.show();

        // 3. *타입변환*
        상위클래스 obj3 = obj2; // 하위메소드가 재정의해 실행
        obj3.show();

    }
}

class 상위클래스{
    int value1 = 10;
    int value2 = 20;
    상위클래스(){System.out.println("상위 탄생");}
    void show(){System.out.println("상위메소드실행");}
}

class 하위클래스 extends 상위클래스{
    int value3 = 30; int value4 = 40;
    // 즉, 인스턴스 1개당 멤버변수 1개씩 생성
    하위클래스(){System.out.println("하위 탄생");}
    // 주위할점 : 오버로딩 vs 오버라이딩
    void show(int a){ } // 오버로딩 // 메소드명은 같지만 매개변수가 다르다

    @Override // 메소드 위에 @Override 명시, Ctrl + Space로 자동완성 가능
    void show(){ // 오버라이딩 // 상위클래스의 메소드 선언부가 모두 동일하면(재정의)
        System.out.println("하위메소드가 재정의해 실행");
     }

    // 즉, 여러개 인스턴스가 메소드 공유한다.
}