package day29;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Exam3 {
    public static void main(String[] args) {
        
        // Set 인터페이스: 여러개 자료들을 저장하는 컬렉션, 단 중복제거, 인덱스(순서) 없다
        // 1. Set 구현
        Set<String> set1 = new HashSet<>();
        // 2. Set   .add(추가할값);
        set1.add("유재석");     set1.add("강호동");
        set1.add("유재석"); // List중복허용, Set중복허용안함
        set1.add(new String("유재석"));
        System.out.println(set1); // [유재석, 강호동]

        // 3. get(index)없다.
        // 4. size(): 항목 개수 반환
        System.out.println(set1.size());
        // 6. remove(자료): 인덱스가 아닌 자료 삭제
        set1.remove("강호동");
        // 7. indexOf(인덱스) 지원불가,
        set1.contains("강호동");
        // 8. clear(): 항목 전체 삭제
        set1.clear();
        // 9. isEmpty(): 항목이 하나도 없으면 true/false
        set1.isEmpty();
        // 10. set컬렉션과 반복문관계
        // 1. 일반 for문 불가능 (인덱스가 없음)
        // 2. 향상된 for문 지원
        for (String str : set1){System.out.println(str);}
        // 3. forEach 지원, 컬렉션객체.forEach((반복변수명) -> { })
        set1.forEach((str) -> {System.out.println(set1);});
        // -활용처: Set(JDBC ResultSet)

        Iterator<String> 순회자 = set1.iterator(); // 인덱스가 아닌 자료들을 순회하는 인터페이스반환
        while(순회자.hasNext()){    // hasNext(): 목록(컬렉션)에서 자료 하나씩 꺼내기(저장된 순서)
        }

        // 11. TreeSet 이용한 자동정렬
        TreeSet<Integer> set2 = new TreeSet<>();
        set2.add(50); set2.add(70); set2.add(60);
        System.out.println(set2);   // 기본값이 오름차순
        System.out.println(set2.descendingSet());   // 내림차순
    }
}
