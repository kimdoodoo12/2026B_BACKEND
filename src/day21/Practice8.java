package day21;

/**
 * Practice8
 */
public class Practice8 {

    public static void main(String[] args) {
/*[문제 1] Book 클래스 (매개변수 생성자 기본)
Book 클래스를 정의하세요. (멤버 변수: title, author, price)
멤버 변수의 타입은 적절하게 선택하시오.
title, author, price를 매개변수로 받아 멤버 변수를 초기화하는 생성자를 정의하세요.
main 함수에서 해당 생성자를 이용하여 다음 두 객체를 생성하고, 각 객체의 필드 값을 출력하세요.
("이것이 자바다", "신용권", 30000)
("자바의 정석", "남궁성", 28000)*/
class Book{
    String title;
    String author;
    int price;

    Book(String title, String author, int price){
        this.title = title;
        this.author = author;
        this.price = price;
    }
}

Book b1 = new Book("이것이 자바다", "신용권", 30000);
Book b2 = new Book("자바의정석", "남궁성", 28000);

System.out.println(b1.title + b1.author + b1.price);
System.out.println(b2.title + b2.author + b2.price);

/*[문제 2] Rectangle 클래스 (매개변수 생성자를 통한 객체 초기화)
Rectangle 클래스를 정의하세요. (멤버 변수: width, height)
멤버 변수의 타입은 적절하게 선택하시오.
width와 height를 매개변수로 받아 초기화하는 생성자를 정의하세요.
main 함수에서 (10, 5) 값을 매개변수로 전달하여 Rectangle 객체를 생성하세요.
생성된 객체의 width와 height 값을 각각 출력하세요.*/

class Rectangle{
    int width;
    int height;

    Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }
}

Rectangle r1 = new Rectangle(10, 5);
System.out.println(r1.height*r1.width);

/*[문제 3] BankAccount 클래스 (다양한 데이터 타입을 가진 생성자)
BankAccount 클래스를 정의하세요. (멤버 변수: accountNumber, ownerName, balance)
멤버 변수의 타입은 적절하게 선택하시오.
세 멤버 변수(accountNumber, ownerName, balance)를 모두 전달받아 초기화하는 생성자를 정의하세요.
main 함수에서 ("111-222-3333", "유재석", 10000) 정보로 BankAccount 객체를 생성하세요.
객체 생성 후, 해당 객체의 계좌번호, 예금주명, 잔액 정보를 출력하여 올바르게 초기화되었는지 확인하세요.*/

class BankAccount{
    String accountNumber;
    String ownerName;
    int balance;

    BankAccount(String accountNumber, String ownerName, int balance){
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }
}

BankAccount userBankAccount1 = new BankAccount("111-222-333", "유재석", 10000);
System.out.println(userBankAccount1.accountNumber + userBankAccount1.ownerName + userBankAccount1.balance); 

/*[문제 4] Goods 클래스 (생성자 오버로딩)
Goods 클래스를 정의하세요. (멤버 변수: name, price)
멤버 변수의 타입은 적절하게 선택하시오.
Goods 클래스에 생성자 오버로딩을 적용하여 두 개의 생성자를 정의하세요.
기본 생성자: name은 "미정", price는 0으로 초기화
매개변수 생성자: name과 price를 전달받아 초기화
main 함수에서 다음 두 객체를 각각 생성하고, 두 객체의 멤버 변수 정보를 출력하세요.
기본 생성자로 생성한 객체
매개변수 생성자를 통해 ("콜라", 2000) 정보로 생성한 객체*/

class Goods{
    String name;
    int price;

    Goods(){
        this.name = "미정";
        this.price = 0;
    }
    Goods(String name, int price){
        this.name = name;
        this.price = price;
    }
}

Goods good1 = new Goods();
Goods good2 = new Goods("콜라", 2000);
System.out.println(good1.name + good1.price);
System.out.println(good2.name + good2.price);



/*[문제 5] Member 클래스 (기본 생성자 및 초기값 설정)
Member 클래스를 정의하세요. (멤버 변수: id, isLogin)
멤버 변수의 타입은 적절하게 선택하시오.
Member 클래스에 기본 생성자를 만들고, 생성자 내부에서 id는 "guest", isLogin은 false로 초기화되도록 구현하세요.
main 함수에서 new Member()로 객체를 생성한 뒤, 초기화된 id와 isLogin 값을 출력하여 확인하세요.*/

class Member{
    String id;
    Boolean isLogin;

    Member(){
        this.id = "guest";
        this.isLogin = false;
    }
}

Member m1 = new Member();
System.out.println(m1.id + m1.isLogin);


    }
}