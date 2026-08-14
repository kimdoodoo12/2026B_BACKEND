package day27.종합예제.controller;

import java.util.ArrayList;

import day27.종합예제.model.dao.BoardDao;
import day27.종합예제.model.dto.BoardDto;

public class BoardController {
    private BoardController(){}
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance(){ return instance; }
    //[*] MVC패턴 흐름의 dao 싱글톤 호출
    private BoardDao bd = BoardDao.getInstance();

    // [1] 등록 Controller
    public boolean save(BoardDto boardDto){
        boolean result = bd.save(boardDto); // view에게 전달받은 매개변수 dao에게 전달
        return result; // dao에게 받은 결과 view 반환
    }

    // [2] 전체조회 Controller
    public ArrayList<BoardDto> findAll(){
        ArrayList<BoardDto> result = bd.findAll();
        return result;
    }

    // [3] 개별수정 Controller
    public boolean update(BoardDto boardDto){
        
        boolean result = bd.update(boardDto);
        return result;
    }

    // [4] 개별삭제 Controller
    public boolean delete(int no){
        boolean result = bd.delete(no);
        return result;
    }
}