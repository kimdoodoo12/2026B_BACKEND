package day23;

public class Exam3 {
    int a;
    void b(){};
    static int c;
    static void c() {};
    public static void main(String[] args) {


        // static으로 main이 우선할당되서 실행되었기에 그냥 선언된 상위의 변수들은 인스턴스화시키지 않으면 쓸수없다.
        // System.out.println(a); // 오류
        // b(); // 오류
        Exam3 exam3 = new Exam3();
        System.out.println(exam3.a);
        exam3.b();

        System.out.println(c);
        c();


        D d1 = new D();
        // [1] final
        // d.고정변수 = 20; // 오류

        // [2] static: 클래스명.(공유)정적변수
        D.정적변수 = 20;    // 총 메모리 1개

        // VS 멤버변수: 객체명.(인스턴스)멤버변수

        d1.멤버변수 = 20;

        D d2 = new D();
        d2.멤버변수 = 30;   // 총 메모리 2개

        D.정적변수 = 30;

        System.out.println(D.상수);
    }
}

class D{
    // final 키워드: 초기값(필수) 이후에 수정 불가능
    public final int 고정변수 = 10;

    // static 키워드: (정적) 인스턴스 없이 우선(프로그램 실행시)할당 변수
    public static int 정적변수 = 10;

    public int 멤버변수 = 10;
    // 무분별한 사용은 메모리 효율성 떨어진다.
    // static 프로그램은 시작시 할당되고 프로그램 종료시 사라진다
    // public static final : 상수(such as 전역변수)
    public static final int 상수 = 30;
    // 주의할점: static 우선할당이므로 static이 아닌 변수/메소드 접근
    // 해결방안: 인스턴스/객체 통해 멤버변수/메소드 사용
}