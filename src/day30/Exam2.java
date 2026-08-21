package day30;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Exam2 {
    public static void main(String[] args) {
        /*
            스택(Stack): 후입선출( LIFO: 가장 마지막에 삽입된 자료가 가장 먼저 삭제된다)
            예) 브라우저(뒤로가기), Ctrl + z (실행취소)
            Stack 클래스 이용한 구현, push 삽입
         */

        Stack<String> stack = new Stack<>();
        stack.push("네이버메인페이지");
        stack.push("뉴스페이지");
        stack.push("블로그페이지"); // 입력: 1. 메인 -> 뉴스 -> 블로그 

        while (! stack.isEmpty()){  // !: 부정문 , !변수명.isEmpty(), 비어있으면 반복문 종료
            System.out.println(stack.pop()); // 출력: 블로그 -> 뉴스 -> 메인
        }
            

        /*
            큐(Queue): 선입선출(FIFO: 가장먼저 삽입된 자료가 가장 먼저 삭제된다.)
            예) 번호(웨이팅)표, 프린트(인쇄) 등등
            - LinkedList 클래스 이용한 구현, offer 입력, poll 출력
         */

        Queue<String> queue = new LinkedList<>();
        queue.offer("1번손님"); queue.offer("2번손님");
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
