package day23.package1;

public class B {

    public void Func(){
        A a = new A();
        a.publicVar = 3;
        a.privateVar = 3; // 불가능
        a.generalVar = 3; // 같은 패키지(A/B)라서 가능
    }

    private B(){} // 비공개 생성자: 외부에서 객체 생성 금지
}
