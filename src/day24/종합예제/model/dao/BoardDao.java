package day24.종합예제.model.dao;

import java.util.ArrayList;

import day24.종합예제.model.dto.BoardDto;

/**
 * BoardDao
 */
public class BoardDao {
    private BoardDao(){}
    private static final BoardDao instance = new BoardDao();
    public static BoardDao getInstance() {return instance;}

    // * 추후에 MYSQL 서버와 연동 *
    // * 데이터베이스 대신에 ArrayList 사용하여 데이터베이스 표/데이터 역할 *
    private ArrayList<BoardDto> boardList = new ArrayList<>();

    // [1] 게시물 작성 로직
    public boolean save(BoardDto boardDto){
        // 1. controller로 부터 저장할 정보 객체 받는다
        // * insert 이용한 db에 저장
        // 2. 리스트에 저장
        boardList.add(boardDto);
        // 3. 성공반환
        return true;
    }

    // [2] 게시물 전체 조회 로직
    public ArrayList<BoardDto> findAll(){
        // 1. controller에게 매개변수 받는다. 현재는 없음
        // * 추후에 select 이용한 db조회
        // 2. 리스트 전체 반환
        return boardList;

    }
}