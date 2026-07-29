package day16;

import java.util.Scanner;

public class Exam3 {
    
    public static void main(String[] args) {
        // System(컴퓨터).out(출력객체).print(출력함수)
        System.out.println("자바안녕");
        System.out.print("자바안녕2");
        System.out.println("\n자바안녕3\t자바안녕4\' \" \\");

        System.out.printf("저는 %s이고 나이는 %d입니다", "섀도우가든", 25);
        System.out.printf("저는 %s이고 나이는 %06d입니다", "섀도우가든", 25);
        System.out.printf("저는 %s이고 나이는 %6d입니다", "섀도우가든", 25);
        System.out.printf("저는 %s이고 나이는 %-6d입니다", "섀도우가든", 25);
        System.out.printf("저는 %6s이고 나이는 %d입니다", "섀도우가든\n", 25);
        System.out.printf("저는 %s이고 나이는 %5.2f입니다", "섀도우가든\n", 123.456788);

        // Scanner : 입력 관련 클래스
        // scanner : 관례적으로 소문자로 선언 (클래스명의 소문자로)
        // new: 인스턴스화, 해당 클래스로 객체 만든다는 것
        Scanner scanner = new Scanner(System.in);

        // 문자일타입 변수명 = 문자열 변환  
        String str1 = scanner.next();
        System.out.printf("%s \n", str1);

        // 입력받은 자료 (정수) 변환
        int i1 = scanner.nextInt();
        System.out.printf("%d \n", i1);
        
    }
    

}
