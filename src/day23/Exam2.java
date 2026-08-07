package day23;

public class Exam2 {
    public static void main(String[] args) {
        // [1]
        User user1 = new User();
        // user1.name = "유재석"; // 접근 불가
        user1.setName("유재석");
        // System.out.println(user1.name); // 불가능
        System.out.println(user1.getName()); // 가능

        //[2] 객체 출력하면 객체주소값 변환 // day08.User@372f7a8d(식별)
        System.out.println(user1);

        System.out.println(user1.toString());

    }
}

class User{
    private String name;
    private int age;

    // -private 메소드에 대한 간접접근 메소드
    // setter , getter, set멤버변수, get멤버변수
    // getter 존재하면 V(value)O(object) 읽기모드
    // setter/getter 존재하면 D(data)T(transfer)O(object) 읽기/쓰기 모드

    public void setName(String name){
        // 추후에 유효성검사를 이용하여 원하는 데이터만 저장
        if (name.length() < 1) { return; }
        this.name = name;
    }
    public String getName(){
        // if (비밀번호 != input) { return }
        return this.name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + "]";
    }
    

    // 3. toString: 객체호출 시 주소값 대신에 문자열 반환
    
    // DTO: 데이터베이스에 있는 자료 --이동--> 프론트엔드
    //      1. 관례적으로 멤버변수 모두 private
    //      2. setter/getter 제공한다
    //      3. toString 제공한다
    //      4. 생성자에 기본생성자 1개, 전체매개변수1개 => 2개를 만들어야함
    // MVC패턴: 소규모가 아닌 체계적인 규모 필요할 때 클래스 역할 나누기
    // Model 데이터 담당       DTO, VO (CONTROLLER-외부DB/클라우드)
    // View 입출력 담당     HTML/CSS/JS/REACT/FLUTTER
    // Controller 제어(백/프) 중계  JAVA/PYTHON/NODE.JS

    // 백엔드 ----> 웹개발, 앱, 소프트웨어

}