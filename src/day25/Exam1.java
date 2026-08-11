package day25;

public class Exam1 {
    public static void main(String[] args) {

        // 1. 동물객체 생성
        Animal animal1 = new Animal();  // 생성자 실행
        animal1.name = "puppy";         // 멤버변수 접근
        animal1.show();                 // 메소드 실행
        // 2. 조류객체 생성
        Birds bird1 = new Birds();      // 조류생성자 + 동물생성자 실행
        bird1.name = "pigeon";          // 동물 멤버변수 접근
        bird1.show();                   // 동물 메소드 실행
        // 즉, 하위/자식 클래스의 객체는 상위/부모 클래스의 멤버(변수/메소드) 사용할수있다.
        // 3. 참새객체 생성
        Sparrow sparrow1 = new Sparrow();
        sparrow1.name = "sparrow";
        sparrow1.show();

        // 4. 닭객체 생성
        Chicken chicken1 = new Chicken();   // 닭생성자 + 조류 생성자 + 동물 생성자
        chicken1.name = "chicken";
        chicken1.show();
        // 즉, 자식이 태어나기 위해 부모가 먼저 태어난다.

        // *** 다형성 ***
        // 하나의 자료가 다양한 형(형식/모양/형태/구분) 성질
        // 1. 참새타입에서 조류 타입변환이 가능한가?
        // 가능한 이유 1) 상속관계(논리) 2) 참새인스턴스가 생성될 때 조류+동물 인스턴스 생성(물리)
        Birds bird2 = sparrow1; // 자동타입변환 / 업캐스팅(Upcasting)
        // 2. 참새타입에서 동물타입으로 가능한가?
        Animal animal2 = sparrow1; // 업캐스팅(Upcasting)
        // 3. 동물타입에서 참새타입으로 될까?
        // 주의할점: 1) 변환타입명시 2) 변환할 자료가 변환할 타입을 포함하는지 봐야함
        Sparrow sparrow2 = (Sparrow)animal2; // 강제타입변환 / 다운캐스팅(Downcasting)
        // 4. 동물타입에서 참새타입으로 될까?
        Sparrow sparrow3 = (Sparrow)animal1; // ** 오류 생김 ** 

        // 즉, 자식이 태어날 때 부모도 태어나지만 반대로 부모가 태어날 경우 자식은 태어나지 않기에 생기는 오류다.
        // animal1은 오직 Animal 객체만 생성, animal2는 sparrow1을 대입하면서 참새+조류+동물생성자까지 태어난다.

        // 1-3 : 자료:참새, 타입:조류
        // --> 자료:참새, 타입: 동물
        // --> 자료:참새, 타입: 참새

        int a = 3;          // 자료 3, 타입 int
        byte b = (byte) a;  // 자료 3, 타입 byte

    }
}

class Animal{ // 부모 클래스
    // 1. 멤버변수
    String name;

    // 2. 생성자
    Animal() {
        System.out.println("동물 탄생");
    }

    // 3. 메소드
    void show(){
        System.out.println("동물 입니다");
    }

}

class Birds extends Animal{ // 하위클래스명 extends 상위클래스명
}
class Sparrow extends Birds{ }
class Chicken extends Birds{}

/*
        동물
         |
        조류
     |       |
    참새     닭
 */