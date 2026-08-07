package day22;

import java.util.Scanner;
import java.util.Date;

public class test2 {
    public static void main(String[] args) {
       OverallRepository review_repository = new OverallRepository();
       OverallRepository post_repository = new OverallRepository();
        Scanner scan = new Scanner(System.in);
        for (;;) {
            System.out.println("============ My Community ============ ");
            System.out.println("1. 리뷰등록, 2. 리뷰출력, 3. 게시물등록, 4. 게시물출력");
            System.out.println("====================================== ");
            System.out.print("선택>");
            int ch = scan.nextInt();

            if (ch == 1) {
                scan.nextLine();
                System.out.print("리뷰내용 : ");     String content = scan.nextLine();
                System.out.print("점수 : ");   String writer = scan.nextLine();

                Post post = new Post(content, writer);
                boolean result = review_repository.save(post);

                if (result) { System.out.println("[안내] 리뷰등록 성공");} 
                else { System.out.println("[안내] 글쓰기 실패"); }

            } else if (ch == 2) {
                Post[] posts = review_repository.findAll();
                for (Post post : posts) {
                    if (post != null) {
                        System.out.printf("리뷰내용 : %s , 점수 : %s \n", post.writer, post.content);
                    }
                }
            } else if (ch == 3) {
                
            } else if (ch == 4) {

            }
        }
    }
}

class OverallRepository {

    Post[] posts = new Post[100];

    boolean save(Post post) {
        for (int index = 0; index < posts.length; index++) {
            if (posts[index] == null) {
                posts[index] = post;
                return true;
            }
        }
        return false;
    }

    Post[] findAll() {
        return posts;
    }


}

class Post {
    String content;
    String writer;

    Post() {
    }

    Post(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }
}

class Posttable {
    int listID; // PK
    int memberID; // FK
    String listTitle;
    String listContent;
    String listDay;
    int thumbsUp;
    int thumbsDown;
}

class cigarTable{
    int cigarID;
    int brandID;
    String cigarName;
    String Category;
    int price;
    float nicotine;
    float tar;
    boolean isCapsule;
    String cigarimg;
}

class reviewTable {
    int reviewID;
    int CigarID;
    int MemberID;
    String review;
    int score;
    String listDay;
}

class memberTable {
    int memberID;
    String userID;
    String userPW;
    String userName;
    String userPhoto;
}

class Brandtable {
    int brandID;
    String brandName;
    String brandLogo;

    Brandtable() {
    }

    Brandtable(int brandID, String brandName) {
        this.brandID = brandID;
        this.brandName = brandName;
    }

}