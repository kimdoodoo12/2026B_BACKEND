package day30;

import java.awt.*;  // java내 UI 제공 = awt/fx
public class Exam3 {
    public static void main(String[] args) {
        /*
            프로그램: 실행 가능한 코드들의 집합
            프로세스: 실행중인 프로그램
            멀티태스킹: 두 가지 이상의 작업을 동시에 처리 = 병렬처리
                멀티프로세스: 운영체제가 여러개 여러 개 프로세스를 동시에 실행하는 구조
                멀티 스레드: 하나의 프로세스 내 여러개 흐름 작업 실행하는 구조
            스레드란? 하나의 프로세스 내 최소 작업 단위 또는 실행 흐름단위
                - CPU가 (운영체제)프로세스내 스레드를 통해 코드를 순차적으로 처리
            main함수란? JAVA/C/PYTHON 내 단일 쓰레드 환경 main 메소드가 제공한다.

         */
        
        // [1] 단일(싱글) 스레드: (컴파일된)코드들을 실행 흐름 단위
        // -> main메소드가 main스레드 제공한다. (프로그램당 1개 이상 존재)
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 1; i <=5; i++){
            toolkit.beep();
            try{
                Thread.sleep(1000);  // 현재 쓰레드 (코드 실행하는 흐름단위) 일시정지(밀리초)
            }catch(Exception e){System.out.println(e);}
            
        }

        // [2] 1초에 한번씩 출력 발생
        for (int i = 1; i <=5; i++){
            System.out.println("띠링");
            try{Thread.sleep(1000);}catch(Exception e){}
        }

    }
}
