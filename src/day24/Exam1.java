package day24;

import java.util.ArrayList;

public class Exam1 {
    /*
        배열: 여러개 (동일한 타입) 자료들을 저장하는 타입, 정적길이
        ArrayList 클래스:
            1. 컬렉션(수집) 프레임(툴)원크(일), 자료 수집관련 클래스/기능 제공
            2. 목적: 가변길이, 배열 관련된 기능(메소드) 제공한다. <편리하다>
            3. 사용법
                ArrayList<제네렉타입> 변수명 = new ArrayList<>();
                - 제네릭타입: 리스트내 저장할 요소들의 타입, 즉 <String> 리스트에 여러개 String 저장
                - 주의할점: <제네릭타입>은 기본 타입이 불가능하다. int -> Integer 레퍼타입(기본타입을 대문자로)
            4. 주요메소드
                1. .add(자료) : 리스트 요소추가
                2. .add(인덱스, 자료) : 리스트 중간 삽입
                3. .set(인덱스, 자료) : 리스트 요소 수정
                4. .size() : 리스트내 요소 개수 변환
                5. .get(인덱스) : 리스트 특정 요소 값 반환
                6. .remove(인덱스) : 리스트 특정 요소 삭제
                7. .clear() : 리스트 요소 전체 삭제
                8. .indexOf(찾을값) : 리스트내 찾을값이 존재하면 인덱스 없으면 -1 반환
                9. .contains(찾을값) : 리스트내 찾을값이 존재하면 true 없으면 false 반환
                10. .isEmpty() : 리스타가 비어있으면 true 아니면 false 반환 
     */

    public static void main(String[] args) {
        
        // [1] 리스트 생성
        ArrayList <String> var1 = new ArrayList<>();
        // [2] 리스트 요소 추가
        var1.add("유재석"); var1.add("강호동"); var1.add("신동엽");
        // [3] 리스트 전체 출력
        System.out.println(var1);
        // [4] 리스트 중간 삽입
        var1.add(1, "하하");
        // [5] 리스트 요소 수정
        var1.set(1, "서장훈");
        // [6] 리스트 요소 총개수
        System.out.println(var1.size());
        // [7] 리스트 요소 출력
        System.out.println(var1.get(1));
        // [8] 리스트 요소 삭제
        var1.remove(1);
        // [9] 리스트 요소 찾기
        System.out.println(var1.indexOf("강호동")); // 강호동 찾을값의 인덱스 반환 없으면 -1
        System.out.println(var1.contains("강호동"));    // 강호동 찾을값이 있으면 true 없으면 false
        // [10] 반복문과 리스트 관계
        for (int index = 0; index <= var1.size(); index++){ String str = var1.get(index); }
        for (String str : var1) {    }

    }
}
