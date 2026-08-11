package day24.종합예제.model.dto;

/**
 * BoardDto
 */
public class BoardDto {
    // DTO: 데이터 이동객체??, 자바는 저장소가 아니다. 즉 데이터베이스(저장소)/FILE/클라우드가 저장소이므로
    // 1. 데이터베이스 표에서 (CRUD)사용할 자료들을 private 멤버변수로 구성

    private String content;
    private String writer;

    // 2. 기본 생성자, 전체 매개변수 생성자
    public BoardDto(){}

    public BoardDto(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }

    // 3. setter and getter, toString
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "BoardDto [content=" + content + ", writer=" + writer + "]";
    }

    
    
}