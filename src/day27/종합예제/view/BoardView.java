 
 	
package day27.종합예제.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import day27.종합예제.controller.BoardController;
import day27.종합예제.model.dto.BoardDto;

public class BoardView {
    private BoardView(){} // 1.
    private static final BoardView instance = new BoardView(); // 2.
    public static BoardView getInstance( ){ return instance; } // 3. 

    // [*] MVC패턴 흐름의 controller 싱글톤 호출
    private BoardController bc = BoardController.getInstance();
    // [*] 입력객체
    private Scanner scan = new Scanner(System.in);
    // [*] 최초 루프/화면
    public void run(){
        while(true){
            try{
                System.out.print("1. 등록 2. 전체조회 3. 개별수정 4. 개별삭제: ");
                int ch = scan.nextInt();
                if (ch == 1){ save(); }
                else if (ch == 2){ findAll(); }
                else if (ch == 3){ update(); }
                else if (ch == 4){ delete(); }    
            }catch(InputMismatchException e){
                scan = new Scanner(System.in);  // 입력(성공) 했지만 타입에서 예외이므로 입력객체 초기화
                System.out.println("[다시입력] " + e);
            }

        }
    } // run end

    // [1] 등록 VIEW
    public void save(){
        System.out.print("내용: "); String 내용 = scan.next();
        System.out.print("작성자: "); String 작성자 = scan.next();
        // 1.2 자료 객체화
        BoardDto boardDto = new BoardDto(0, 내용, 작성자); // no는 Dto에 구조상 사용 X
        // 1.3 컨트롤러에게 전달하여 응답받기
        boolean result = bc.save(boardDto);
        if (result){System.out.println(">등록성공");}
        else {System.out.println(">등록실패");}
    }

    // [2] 전체조회 VIEW
    public void findAll(){
        ArrayList<BoardDto> result = bc.findAll();
        // 2. 반복문 이용하여 출력
        for (BoardDto dto: result){
            System.out.println(dto.getNo()+" , " + dto.getContent() + " , " + dto.getWriter() );
        }
    }

    // [3] 개별수정 VIEW
    public void update(){
        System.out.print("수정할 번호: "); int 수정번호 = scan.nextInt();
        System.out.print("수정할 내용: "); String 수정내용 = scan.next();
        BoardDto boardDto = new BoardDto(수정번호, 수정내용, null);
        boolean result = bc.update(boardDto);
        
        if(result){System.out.println(">수정 성공");}
        else{System.out.println(">수정실패");}
    }

    // [4] 개별삭제 VIEW
    public void delete(){
        System.out.print("삭제번호: "); int 삭제번호 = scan.nextInt();
        
        boolean result = bc.delete(삭제번호);
        if (result) {System.out.println(">삭제성공");}
        else {System.out.println(">삭제실패");}
    }
}
