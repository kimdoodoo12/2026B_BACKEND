package day25;

public class Exam2 {
    public static void main(String[] args) {
        
        // 자바는 100% 객체지향언어이다.
        // Object(슈퍼클래스) 클래스로부터 모든 클래스는 상곡관계
        // 1.
        A a = new A(); // 총 2개, A ---> Object
        B b = new B(); // 총 3개, B --> A --> Object
        C c = new C(); // 총 3개, C --> A --> Object
        D d = new D(); // 총 4개, D --> B --> A --> Object
        E e = new E(); // 총 4개, E --> C --> A --> Object

        // [2] 자동타입변환 / 업캐스팅
        A a2 = b; // B --> A [가능]
        Object o1 = a2; // A -> Object [가능]

        // [3] 강제타입변환 / 다운캐스팅
        A b2 = (B)a2; // A --> B [가능] 태생이 B라서
        // C c2 = (C)b; // 형제 
        
        // [4] 타입확인, 인스턴스 instanceOf 타입명
        System.out.println(e instanceof Object); // e --> Object // Always true
        System.out.println(e instanceof C); // e --> C // true
        System.out.println(e instanceof D); // e --> D // false
        System.out.println(e instanceof B); // e --> B // false
        // 즉 타입변환 전에 instanceof 키워드 활용하여 타입확인후 타입변환<안전>


    }
}

class A{
    A(){System.out.println("A객체 생성");}
}
class B extends A{
    B(){System.out.println("B객체 생성");}
}
class C extends A{
    C(){System.out.println("C객체 생성");}
}
class D extends B{
    D(){System.out.println("D객체 생성");}
}
class E extends C{
    E(){System.out.println("E객체 생성");}
}