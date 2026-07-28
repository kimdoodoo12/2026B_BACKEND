/*
    .java 파일 만들기
    

    Ctrl + F5 또한 실행 단축키
 */

package day01; // 패키징(폴더명)이면서 클래스의 위치 식별용도

public class Exam1 {
    // public: 공개용, 다른 패키지에서 사용 가능한 클래스
    // class: 클래스 선언 사용하는 키워드
    // 클래스명의 첫글자는 대문자
        // 클래스는 자바에서의 가장 최소 컴파일 단위
    
    int b = 10;
    // 실행 시작점 생성, main 함수 (Thread)
    // js에 없는 이유는 브라우저가 엔진을 대신한다
    public static void main(String[] args) {
        int a = 10;
        System.out.println(a);
    }

}
