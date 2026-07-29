package day02;

import java.util.Scanner;

/**
 * Practice1
 */
public class Practice1 {
    public static void main(String[] args) {

/* 문제 1: 리터럴(Literal)과 기본 출력 함수
지시: System.out.println() 함수를 사용해서 숫자 25와 문자열 "홍길동"을 각각 다른 줄에 출력 하시오.*/
        System.out.println(25);
        System.out.println("홍길동");
/* 문제 2: 변수(Variable) 선언과 기본 타입(Type)
지시: int 타입의 변수 age를 선언하고, 자신의 임의의 나이를 리터럴로 대입한 뒤, 변수 age를 출력해 보세요.*/

        int age = 40;
        System.out.println(age);

/* 문제 3: 다양한 타입의 변수 활용
지시: 아래 4개의 변수를 선언하고 리터럴로 임의의 값을 넣어 초기화하세요. (출력은 하지 않아도 됩니다)
이름: String 타입의 name
나이: int 타입의 age
키: double 타입의 height
좌우명: String 타입의 motto*/
        String name = "홍길동";
        int age2 = 25;
        double height = 175.5;
        String motto = "";

/* 문제 4: 출력 함수와 문자열 연결
지시: 문제 3에서 만든 변수들을 System.out.println() 함수와 + 연산자를 사용하여 아래와 같이 한 문장으로 출력하세요.
예시: 제 이름은 홍길동, 나이는 25세, 키는 175.5cm 입니다.*/

        System.out.println("제 이름은" + name + ", 나이는" + age2 + "세, 키는 " + height + "cm입니다");

/* 문제 5: printf와 서식 지정자(Format Specifier)
지시: 문제 4의 출력문을 System.out.printf() 함수와 서식 지정자를 사용하도록 수정하세요.
요구 조건: 키(height)는 서식 지정자를 이용해 소수점 첫째 자리까지만 표시하세요.
예시: 제 이름은 홍길동, 나이는 25세, 키는 175.5cm 입니다.*/

System.out.printf("제 이름은 %s, 나이는 %d세, 키는 %.1fcm입니다\n", name, age2, height);

/* 문제6: 아래와 같이 이스케이프 문자를 이용하여 콘솔에 출력하는 코드를 작성하시오.
 |\_/|
 |q p|   /}
 ( 0 )"""\
 |"^"`    |
 ||_/=\\__|
 */

 System.out.print(" |\\_/|\r\n" + //
          " |q p|   /}\r\n" + //
          " ( 0 )\"\"\"\\\r\n" + //
          " |\"^\"`    |\r\n" + //
          " ||_/=\\\\__|\n");


/* 문제7 : 아래 조건에 3가지의 변수가 주어졌을때. 그림과 같이 printf 이용한 출력 하는 코드를 작성하시오.
int num = 1;    // 정수 1 를 저장하고 있는 int 타입 'num' 변수 선언
String writer = "유재석"; // 문자열 "유재석" 를 저장하고 있는 String타입 'writer' 변수 선언
String content = "안녕하세요!"; // 문자열 "안녕하세요!"를 저장하고 있는 String타입 'content' 변수 선언
예시 :
=========== 방문록 ============
번호   작성자   방문록
1      유재석   안녕하세요!
============================
*/

int num = 1;
String writer = "유재석";
String content = "안녕하세요!";
System.out.printf("=========== 방문록 ============\r\n" + //
        "번호   작성자   방문록\r\n" + //
        "%d      %s   %s\r\n" + //
        "============================", num, writer, content);

/* 문제 8: Scanner를 이용하여 사용자의 이름(String)과 나이(int)를 입력받아, "OOO님의 나이는 OO세 입니다." 형식으로 출력하는 코드를 작성하시오.
입력 예시:
이름을 입력하세요: 유재석
나이를 입력하세요: 51
출력 예시:
유재석님의 나이는 51세 입니다.
*/

Scanner scanner = new Scanner(System.in);
System.out.print("이름을 입력하세요: "); String inputName = scanner.next();
System.out.print("나이를 입력하세요: "); int inputAge = scanner.nextInt();

System.out.printf("%s님의 나이는 %d세 입니다", inputName, inputAge);


/*
문제 9: Scanner를 이용해 게시물 번호(int), 제목(String), 내용(String)을 순서대로 입력받아 출력하시오.
요구 조건: 제목과 내용은 띄어쓰기가 포함될 수 있으므로 nextLine()을 사용하시오.
입력 예시:
게시물 번호: 1
제목: 자바는 재미있어요
내용: 정말입니다. 다들 동의하시죠?
출력 예시:
[ 1번 게시물 ]
제목: 자바는 재미있어요
내용: 정말입니다. 다들 동의하시죠?
*/

System.out.print("게시물 번호: "); int inputNumber = scanner.nextInt();
System.out.print("제목: "); String inputTitle = scanner.nextLine();
System.out.print("내용: "); String inputContent = scanner.nextLine();

System.out.printf("[ %d번 게시물 ]\r\n" + //
        "제목: %s\r\n" + //
        "내용: %s", inputNumber, inputTitle, inputContent);




/*
문제 10: Scanner를 이용해 성별을 한 글자('남' 또는 '여')로 입력받아 char 타입 변수에 저장하고, 입력된 성별을 출력하시오.
요구 조건: Scanner에는 nextChar() 함수가 없으므로 next().charAt(0)을 활용하시오.
입력 예시:
성별을 입력하세요(남/여): 남
출력 예시:
입력하신 성별은 '남' 입니다.
*/

System.out.print("성별을 입력하세요(남/여): "); char sex = scanner.next().charAt(0);
System.out.printf("입력하신 성별은 %c", sex);



/*
문제 11: Scanner를 사용하여 아래 4가지 정보를 순서대로 입력받아 출력하는 코드를 작성하시오.
이름 (String), 나이 (int), 키 (double), 프로그래머 여부 (boolean)
입력 예시:
이름: 김자바
나이: 25
키: 165.8
프로그래머입니까? (true/false): true
출력 예시:
--- 자기소개 ---
이름: 김자바
나이: 25
키: 165.8cm
프로그래머 여부: true
*/

System.out.print("이름을 입력하세요: "); String name3 = scanner.next();
System.out.print("나이를 입력하세요: "); int age3 = scanner.nextInt();
System.out.print("키를 입력하세요: "); double height3 = scanner.nextDouble();
System.out.print("프로그래머입니까? (true/false): "); boolean isDeveloper = scanner.nextBoolean();

System.out.println("--- 자기소개 ---");
System.out.println("나이: " + age3);
System.out.println("키: " + height3);
System.out.println("프로그래머 여부: " + isDeveloper);

}
   
    
}

