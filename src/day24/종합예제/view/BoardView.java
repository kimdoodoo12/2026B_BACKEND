package day24.종합예제.view;

import java.util.ArrayList;
import java.util.Scanner;

import day24.종합예제.controller.BoardController;
import day24.종합예제.model.dto.BoardDto;

public class BoardView {
    private BoardView(){} // 1.
    private static final BoardView instance = new BoardView(); // 2.
    public static BoardView getInstance() {return instance;} // 3.
    private BoardController bc = BoardController.getInstance(); // *view에서 controller 싱글톤 호출

    // * 모든 메소드에서 사용 가능한 입력 객체
    private Scanner scanner = new Scanner(System.in);

    // [*] 메인 입출력
    public void run(){ // 무한루프
        while(true){
            System.out.print("1. 등록 2. 전체조회 : ");
            int ch = scanner.nextInt();
            if (ch == 1) {save();}
            else if (ch == 2) {findAll();}
        }
    }

    // [1] 게시물 작성 입출력
    public void save(){
        // 1. 입력받기
        System.out.println("내용: ");   String 내용 = scanner.next();
        System.out.print("작성자: ");   String 작성자 = scanner.next();
        // 2. 객체화
        BoardDto boardDto = new BoardDto(내용, 작성자);
        // 3. 컨트롤러에게 요청하고 응답받기
        boolean result = bc.save(boardDto);
        // 4. 처리한다
        if (result){ System.out.println("등록성공!");}
        else{System.out.println("등록실패");}
    }


    // [2] 게시물 전체 출력
    public void findAll(){
        // 1. 컨트롤러로부터 모든 게시물 요청하고 받는다.
        ArrayList<BoardDto> result = bc.findAll();
        // 2. 컨트롤러로부터 받은 모든 게시물 출력한다.
        for (BoardDto board: result){
            System.out.println(board.getWriter() + " : " + board.getContent());
        }
    }
}
