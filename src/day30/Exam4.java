package day30;

import java.awt.Toolkit;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Exam4 {
    public static void main(String[] args) {
        // [1] 시계

        시계소리쓰레드 시계소리쓰레드 = new 시계소리쓰레드();
        시계쓰레드 시계쓰레드 = new 시계쓰레드();
        Thread clock = new Thread(시계쓰레드);
        Thread tick = new Thread(시계소리쓰레드);
        타이머스레드 timer = null;

        clock.start();
        tick.start();

        // [3] 타이머 구현 [3. 타이머스레드]

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("1. ON , 2. OFF : ");
            int ch = scanner.nextInt();
            if (ch == 1){
                timer = new 타이머스레드();
                timer.start();
            }
            if (ch == 2){
                if (timer != null){
                    timer.state = false;
                }
            }
        }
    }
}

class 시계쓰레드 implements Runnable{
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            System.out.println(LocalTime.now());
            try{Thread.sleep(1000);} catch(Exception e){}
        }
    }
}

class 시계소리쓰레드 implements Runnable{
    @Override
    public void run() {
        // TODO Auto-generated method stub
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        
        while (true) {
            toolkit.beep();
            try{Thread.sleep(1000);}catch(Exception e){}
        }
    }
}

class 타이머스레드 extends Thread{
    public boolean state = true;    // 타이머 작동여부

    @Override
    public void run() {
        int time = 0;
        while (state) {
            time++; // 1초 증가
            System.out.println("타이머: " + time + "초");
            try{Thread.sleep(1000);}catch(Exception e){}
        }
    }
}