package day26.종합예제.model.dto;

public class BoardDto extends BaseTime {
    private String content;
    private String writer;

    public BoardDto() {
        super();
    }

    public BoardDto(String content, String writer) {
        super();
        this.content = content;
        this.writer = writer;
    }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getWriter() { return writer; }
    public void setWriter(String writer) { this.writer = writer; }

    @Override
    public String toString() {
        return "BoardDto [writer=" + writer + ", content=" + content + ", cdate=" + getCdate() + "]";
    }
}