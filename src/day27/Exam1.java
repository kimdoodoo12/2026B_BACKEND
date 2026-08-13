package day27;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exam1 {
    public static void main(String[] args) {
    // 예외란? 에러 발생시 고치는게 아니라 흐름제어 vs if
    // 예외처리: try{예외발생코드} catch()


    // [1] 일반예외: 실행(컴파일) 하기 전 에외가 발생할 수 있음
    // 1. ClassNotFoundException: 클래스 찾을 수 없다
    try{
        Class.forName("java.lang.String"); // Class.forName("찾을 클래스") 동적으로 존재하는 클래스 로드
    }catch(ClassNotFoundException e){
        System.out.println("존재하지 않은 클래스 입니다");
    }

    // 2. InterruptedException: 스레드에 문제가 발생 하면
    try{
        Thread.sleep(1000); // 스레드란? 컴파일된 코드들을 읽어드리는 흐름
    }catch(InterruptedException e){
        System.out.println("인터럽트 문제 발생");
    }
    // [2] 실행예외: 실행(컴파일) 후 예외 발생 *경험 중요* 예측하거나 유지보수 (로그)
    // 3. NullPointerException: 참조가 없는 참조하는 경우
    try{
        String str1 = null; // null이란 참조값이 없다. 즉 객체(인스턴스)가 없다
        System.out.println(str1.length()); // .(도트/접근)연산자는 참조할 대상의 멤버들 접근
    } catch (NullPointerException e){ System.out.println(e);}

    // 4. NumberFormatException: 정수타입으로 변환이 불가능한 경우
    try{
        String str2 = "100";    Integer.parseInt(str2);
        String str3 = "100a";   Integer.parseInt(str3);
    }catch(NumberFormatException e){
        System.out.println(e);
    }
    // 5. ArrayIndexOutOfBoundsException: 배열 내 인덱스 범위가 넘는 경우
    try{
        int [] 배열 = {10, 25};
        System.out.println(배열[0]);
        System.out.println(배열[5]); // 없는 인덱스 호출/사용
    }catch(ArrayIndexOutOfBoundsException e){System.out.println(e);}
    // * 에러 타입들의 예외들을 하나의 타입으로 Exception (상위) 클래스 사용 가능하다

    // [3] 다중 catch: try에서 다양한 예외들을 다양하게 흐름 제어, catch 1번!
    // [4] finally: 예외가 발생 여부 상관없이 무조건 실행구역, 외부 프로그램 연동 종료 코드
    // 6. InputMismatchExceptionJ: 입력 타입 예외 발생
    Scanner scanner = new Scanner(System.in);
    
    try{
        System.out.println("정수 입력: ");
        int ch = scanner.nextInt(); // nextInt() 입력받은 자료들을 INT타입 변환\
        Integer.parseInt("ABC"); // 예외
    }catch(InputMismatchException e){
        System.out.println("정수만 입력하세요" + e);
    }catch(NumberFormatException e){
        System.out.println("타입변환 오류" + e);
    } catch(Exception e){ // 다중 catch에서 마지막에 Exception 사용하여 그외 처리한다
        System.out.println(e);
    }finally{System.out.println("무조건 실행1");}
    System.out.println("무조건 실행2");

    // * try {예외발생할것 코드} catch (예외 클래스명 변수명) { } finally { }

    // [5] 예외 던지기(떠넘기기), *예외반환*: 해당 메소드들을 호출한 곳으로 예외반환
    try{
        method1(); // 예외가 반환에 따라 예외처리 해야한다, 일반예외?
    } catch(Exception e){System.out.println("메소드 예외 발생" + e);}

    }
    // 7. 예외 발생시 발생한 곳에서 예외처리하지 않고 반환
    public static void method1() throws ClassNotFoundException{
        Class.forName("java.lang.Spring"); // 예외 발생
    }

}


