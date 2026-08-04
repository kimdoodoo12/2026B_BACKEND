package day20;
class Book {
  String title;
  // 생성자: 객체 생성 시 전달받은 도서 제목(title)으로 멤버변수(필드)를 초기화합니다.
  Book(String title) { this.title = title; } 
}
public class Main {
  public static void main(String[] args) {

    // 인스턴스 b1 생성
    Book b1 = new Book("Java Basics"); 
    // 인스턴스 b2 생성
    Book b2 = new Book("OOP Concepts"); 

    // Book 객체를 참조할 배열을 선언, 즉 Book객체나 인스턴스가 아님
    Book[] library = new Book[3]; 

    // library[0]는 b1이 가리키는 똑같은 곳을 참조
    library[0] = b1;

    // 인스턴스를 library[1] 생성
    library[1] = new Book("Data Structure"); 


    // b3는 library[1]이 가리키는 똑같은 곳을 참조
    Book b3 = library[1]; 

    //  b2는 원래있던 객체의 참조가 아닌 library[0] -> b1, 즉 b1이 가리키는 똑같은 곳을 참조. OOP Concepts는 참조가 아예 끊김
    b2 = library[0]; 

    // 새로운 객체 배열 archive생성과 library 배열을 참조
    Book[] archive = library;

    // archive[2] -> library[2]로 같은 배열을 참조하고, 인스턴스 생성
    archive[2] = new Book("Algorithm");

    // library[0] -> null
    library[0] = null;

    // b1 -> null
    b1 = null;

    // ===== 프로그램 실행 종료 직전 (Final State) =====
    // 제시된 코드에서 총 인스턴스는 몇개 만들어졌고 main함수가 종료 되기 전 유효 한 인스턴스는 몇 개 이고 몇개가 사라졌을까?
    // 인스턴스 총 5개가 만들어 졌고, 1  개의 참조가 끊겼으니 GC는 외부로부터 참조되지 않는 2개의 객체를 수집하여 처리함
  }
}
