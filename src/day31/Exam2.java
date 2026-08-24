package day31;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Exam2 {
    /*
        스레드풀: 매번 새로운 스레드 생성하지 않고 미리 일정한 스레드를 풀(pool)에 생성
        목적: 과부하 방지
        구조: 선입선출(queue)방식으로 먼저 요청이 들어온 순서대로 대기중인 스레드가 처리한다.
        만일 대기중인 스레드가 없으면 요청은 wait(대기) 상태이며 스레드가 작업이 끝나고 대기중인 요청 처리
        활용처: 웹서버(톰캣), JDBC, 안정한 서버 구축 등등
     */

    public static void main(String[] args) {

        //[1] 스레드풀 구축(미리 스레드 수 생성)
        // ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(3);
        ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(3);

        // [2] 임의의 요청 스레드 생성(구현체)

        Runnable runnable = new Runnable(){
            @Override public void run(){
                for (int i = 1; i <= 20; i++){
                    try{Thread.sleep(3000); }catch(Exception e){}
                    // [3] 스레드풀에 해당 구현체 배정
                    CallTask task = new CallTask(i);
                    poolExecutor.submit(task);

                    // [6] 현재 스레드 상태
                    int runningThread = poolExecutor.getActiveCount();
                    int waitingThread = poolExecutor.getCorePoolSize() - runningThread;
                    int waitingQueue = poolExecutor.getQueue().size();
                    System.out.println("작업중인 스레드수: " + runningThread);
                    System.out.println("대기중인 스레드수: " + waitingThread);
                    System.out.println("대기중인 요청수: " + waitingQueue);
                }
                // [4] 20개 배정후 스레드풀 종료 예약 (모든 작업이 끝나면)
                poolExecutor.shutdown();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();



    }

}

// [2] 작업(요청) 스레드
class CallTask implements Runnable{
    private Random random = new Random();
    private int id;
    public CallTask(int id){this.id = id;} // 생성자

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName(); // 현재 작업스레드명 호출(식별용)
        System.out.println(threadName + "상담원이 고객통화 시작됨 고객 id: " + id);
        try{Thread.sleep(6000 + random.nextInt(6000));}catch(Exception e ){}
        System.out.println(threadName + "상담원이 고객통화 종료됨");
    }
}