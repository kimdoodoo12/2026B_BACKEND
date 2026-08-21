package day29;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Exam2 {
    public static void main(String[] args) {
        // 제네릭: 클래스내 타입들을 인스턴스 생성시 정한다.
        /*
            컬렉션(수집)프레임(툴)워크(일)
                - 정의: 데이터 수집(목록)하는 자료구조(방법) 미리 만들어둔 인터페이스/클래스들
                - 목적: 복잡한 자료들을 편리하게 사용
                - 종류:
                    List 인터페이스:    구현제: ArrayList, Vector, LinkedList, Stack, Queue 등
                    Set 인터페이스:     구현체: HashSet, TreeSet 등
                    Map 인터페이스:     구현체: HashMap, HashTable, TreeMap 등
                * 인터페이스란? 서로 다른 클래스들을 하나의 타입으로 조작
                * 구현체란? 인터페이스 내 추상메소드 구현한 클래스들을
                * 다형성? (캐스팅) 하나의 자료가 서로 다른 타입으로 변환
        */
       // [1] List 인터페이스
       ArrayList<String> list1 = new ArrayList<>();
       list1 = new LinkedList(); // 불가능 // 형제끼리 타입변환 불가능

       List<String> list2 = new ArrayList<>();
       list2 = new LinkedList<>(); // 다형성

       // [2] List 인터페이스 타입으로 구현체 메소드 사용가능, 오버라이딩
       list2.add("shit");
       System.out.println(list2.get(0));
       list2.add("type");

       // [3] 리스트/배열과 반복문 관계 // 리스트(목록)내 항목(값)들을 한번에 꺼내는 것은 없다
       // 1. 일반 for문
       for (int index = 0; index <= list2.size(); index++){
        String str = list2.get(index);
       }

       // 콜론 기준으로 오른쪽에 리스트들을 하나씩 왼쪽에 대입 반복
       for (String str : list2){}

       // 반복메소드, 리스트객체.forEach( (반복변수명) -> { });
       list2.forEach((str) -> {});

       // [4] List 구현체 차이: 사용버(함수/메소드) 동일 ,구조적 차이
       // ArrayList:    인덱스 기반의 배열 구조 + 동기화 미지원
       //               [A] [B] [C] [D]     // E 저장한 경우 마지막 뒤에 E저장
       //                0   1   2   3      // B 삭제한 경우 삭제된 B 이후로 C D가 한칸씩 앞으로 이동
       // 즉 삽입이 빠르다

       // LinkedList:   링크 [h헤더][d본문][t꼬리] = 노드 기반의 리스트 구조
       //               [][A][B주소]     [A주소][B][C주소]     [B주소][C][D주소]     [C주소][D][]
       //               E 저장한 경우 마지막 D꼬리에 E주소를 저장하고 E헤더에 D주소를 저장
       //               B 삭제한 경우 삭제할 노드에 꼬리에 주소를 헤더노드에 꼬리에 대입한다
       //               [][A][C주소]     [A주소][C][D주소]       [C주소][D][]
       // 즉 중간 삽입/삭제 빠르다
       
       // Vector:       ArrayList 동일한 구조 + 동기화(스레드)지원


    }
}
