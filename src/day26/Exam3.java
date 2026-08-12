package day26;

public class Exam3 {
    public static void main(String[] args) {
        Car myCar = new Car();
        // myCar.run();
        myCar.tire = new HankukTire();
        myCar.run();
        myCar.tire = new KumhoTire();
        myCar.run();

        System.out.println(myCar.tire instanceof Tire);
        System.out.println(myCar.tire instanceof KumhoTire);
        System.out.println(myCar.tire instanceof HankukTire);

        // [*] 익명 (클래스없이)구현체 = 일회성 사용하는 인터페이스 구현체
        // *자체적으로 추상메소드 오버라이딩*
        // new 인터페이스명() {오버라이딩}
        myCar.tire = new Tire() {
            @Override
            public void roll() {
                System.out.println("일반타이어 회전");
            }
        };
        myCar.run(); // 일회성 타이어 회전
    }
}

class Car{
    Tire tire;
    void run(){this.tire.roll();}
}

interface Tire{
    void roll(); // { } 없는 추상메소드

}

// 구현체
class HankukTire implements Tire{
    // 추상메소드 { } 구현(재정의)
    @Override
    public void roll() {
       System.out.println("한국 타이어 회전"); 
    }
}

class KumhoTire implements Tire{
    @Override
    public void roll() {
        System.out.println("금호 타이어 회전");
    }
}