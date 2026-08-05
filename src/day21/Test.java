package day21;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        
        Post[] posts = new Post[100];
        Scanner scanner = new Scanner(System.in);


        for (;;){
        System.out.println("============ My Community ============ ");
        System.out.println("1.게시물쓰기 2.게시물출력");
        System.out.println("======================================");
        System.out.print("선택> ");
        int ch = scanner.nextInt();

        if (ch == 1){
            scanner.nextLine();
            System.out.print("내용: ");
            String content = scanner.nextLine();
            System.out.print("작성자: ");
            String writer = scanner.nextLine();

            Post post = new Post(content, writer);
            Boolean result = false;

            for (int i = 0; i < posts.length; i++){
                if(posts[i] == null){
                    result = true;
                    posts[i] = post;
                    break;
                }
            }
            
            if (result){
                System.out.println("글쓰기 성공");
            }
            else{ System.out.println("글쓰기 실패!");}

        }
        else if (ch == 2){
            for(Post post: posts){
                if (post != null){
                    System.out.printf("내용: %s, 작성자: %s\n", post.content, post.writer);
                }
                
            }
        }
        }




    }

}

class Post{
    String content;
    String writer;

    Post(String content, String writer){
        this.content = content;
        this.writer = writer;
    }
}