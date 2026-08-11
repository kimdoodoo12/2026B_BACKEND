package day24.종합예제.controller;

import java.util.ArrayList;

import day24.종합예제.model.dao.BoardDao;
import day24.종합예제.model.dto.BoardDto;

public class BoardController {
    private BoardController(){}
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance() {return instance;}

    private BoardDao bd = BoardDao.getInstance(); // *controller에서 dao 싱글톤 호출

    // [1] 게시물 작성 컨트롤러
    public boolean save(BoardDto boardDto){
        // 1. view로 부터 저장할 정보 객체로 받는다
        // * 유효성 검사/ 타입 변환 등등
        // 2. DAO에게 요청하고 응답받기
        boolean result = bd.save(boardDto);
        // 3. DAO에게 받은 결과를 view에게 응답하기
        return result;
    }

    // [2] 게시물 전체 조회
    public ArrayList<BoardDto> findAll(){
        // 1. view에게 매개변수 받는다. 현재는 없음
        // 2. dao에게 요청하고 응답을 받는다.
        ArrayList<BoardDto> result = bd.findAll();
        return result;
    }
}
