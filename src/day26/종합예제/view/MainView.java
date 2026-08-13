package day26.종합예제.view;

import java.util.ArrayList;
import java.util.Scanner;

import day26.종합예제.controller.BoardController;
import day26.종합예제.controller.ProductController;
import day26.종합예제.model.dto.BoardDto;
import day26.종합예제.model.dto.ProductDto;

public class MainView {
    private MainView() {}
    private static final MainView instance = new MainView();
    public static MainView getInstance() { return instance; }

    private BoardController bc = BoardController.getInstance();
    private ProductController pc = ProductController.getInstance();
    private Scanner scan = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("\n========== 메인 메뉴 ==========");
            System.out.print("1.게시물 관리 2.제품 관리 3.종료: ");
            String ch = scan.next();

            if (ch.equals("1")) { boardMenu(); }
            else if (ch.equals("2")) { productMenu(); }
            else if (ch.equals("3")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    // --- 게시물 메뉴 ---
    private void boardMenu() {
        while (true) {
            System.out.println("\n--- [게시물 관리] ---");
            System.out.print("1.등록 2.전체조회 3.이전메뉴: ");
            String ch = scan.next();

            if (ch.equals("1")) { saveBoard(); }
            else if (ch.equals("2")) { findAllBoards(); }
            else if (ch.equals("3")) { break; }
            else { System.out.println("잘못된 입력입니다."); }
        }
    }

    private void saveBoard() {
        System.out.print("내용: ");
        String content = scan.next();
        System.out.print("작성자: ");
        String writer = scan.next();

        BoardDto boardDto = new BoardDto(content, writer);
        if (bc.save(boardDto)) {
            System.out.println("[안내] 게시물 등록 성공");
        } else {
            System.out.println("[오류] 게시물 등록 실패");
        }
    }

    private void findAllBoards() {
        ArrayList<BoardDto> list = bc.findAll();
        System.out.println("\n===== 게시물 목록 =====");
        if (list.isEmpty()) {
            System.out.println("등록된 게시물이 없습니다.");
            return;
        }
        for (BoardDto board : list) {
            System.out.printf("[%s] %s : %s\n", board.getCdate(), board.getWriter(), board.getContent());
        }
        System.out.println("=======================");
    }

    // --- 제품 메뉴 ---
    private void productMenu() {
        while (true) {
            System.out.println("\n--- [제품 관리] ---");
            System.out.print("1.등록 2.전체조회 3.이전메뉴: ");
            String ch = scan.next();

            if (ch.equals("1")) { saveProduct(); }
            else if (ch.equals("2")) { findAllProducts(); }
            else if (ch.equals("3")) { break; }
            else { System.out.println("잘못된 입력입니다."); }
        }
    }

    private void saveProduct() {
        System.out.print("제품명: ");
        String name = scan.next();
        System.out.print("가격: ");
        int price = scan.nextInt();

        ProductDto productDto = new ProductDto(name, price);
        if (pc.save(productDto)) {
            System.out.println("[안내] 제품 등록 성공");
        } else {
            System.out.println("[오류] 제품 등록 실패");
        }
    }

    private void findAllProducts() {
        ArrayList<ProductDto> list = pc.findAll();
        System.out.println("\n===== 제품 목록 =====");
        if (list.isEmpty()) {
            System.out.println("등록된 제품이 없습니다.");
            return;
        }
        for (ProductDto product : list) {
            System.out.printf("[%s] 제품명: %s | 가격: %,d원\n", product.getCdate(), product.getName(), product.getPrice());
        }
        System.out.println("=====================");
    }
}