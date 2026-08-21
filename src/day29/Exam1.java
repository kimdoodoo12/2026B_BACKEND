package day29;

import java.util.ArrayList;

import javax.swing.Box;

public class Exam1 {
    public static void main(String[] args) {
        /*
            제네릭 타입
            정의: 여러가지 타입에서 동작할 수 있도록 만든 타입
            목적: 클래스 정의할 때 타입 정하지않고 사용자(개발자)가 사용할 때 타입 정한다.
            사용법:
                1) 제네릭타입은 영 대문자로한다
                2) 여러개 가능하다
                3) 기본타입 불가능하므로 래퍼클래스 사용한다
            
         */
        
        // 1] 클래스내 객체 멤버변수 동일한 타입으로 값 대입
        Box1 box1 = new Box1();
        box1.content = "안녕하세요";
        // 2] String 대신에 int 타입으로 값 대입???? 새로운 클래스 만든다.
        Box2 box2 = new Box2();
        box2.content = 10;  // 동일한 멤버변수간 서로 다른타입 불가능???
        // 3] 해결방안? 제네릭 이용한 동일한 멤버변수간 서로 다른 타입 사용.

        // - 사용하는 사람이 제네릭타입 정한다
        Box3<String> box3 = new Box3<String>();
        box3.content = "하하";
        Box3<Integer> box33 = new Box3<>();  // 생성자 뒤에 제네릭 생략 가능
        box33.content = 10;

        // - 제네릭타입 대신에 Object로 사용시에는 타입변환 필요.
        ArrayList<String> list = new ArrayList<>(); // < 제네릭 > String 타입으로 배열
        String[] list2 = new String[10];

        // 4] 2개 이상의 제네릭 타입 가능
        Box4<String, Integer> box4 = new Box4<>();

        // 5] 중첩 가능
        Box4<String , ArrayList< Integer > > box44 = new Box4();
        box4. value1 = "안녕하세요";    box44.value2 = new ArrayList<Integer>();

        // 활용처: 컬렉션프레임워크(ArrayList)
        // 6] 메소드 제네릭 가능 (메소드의 매개변수와 반환 타입 또한 제네릭 가능)
        Box3<String> box333 = Util.boxing("사과");
        System.out.println(box333.content);

        // 7] 상속관계 제약, <타입 extends 상위타입>
        // Box5<String> box5 = new Box5(); // String 타입은 number타입의 자식이 아니라서 불가능
        Box5<Integer> box5 = new Box5();    // Integer타입은 Number 타입의 자식이라서 가능
    }
}
class Box5 <T extends Number>{  // T(제네릭) 타입에는 Number 자식타입만 가능하도록 제약
    T content;
}
class Util{
    public static <T> Box3<T> boxing(T 매개변수){ // 메소드의 타입들을 제레틱 타입 가능
        Box3<T> box3 = new Box3();
        box3.content = 매개변수;
        return box3;

    }
}
class Box4<T, E>{ T value1; E value2;}
class Box3<제네릭타입>{제네릭타입 content;} // <> 이용한 미지수 타입 지정
class Box2{int content;}
class Box1{String content;}
