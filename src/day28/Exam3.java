package day28;

import java.util.Arrays;

public class Exam3 {
    public static void main(String[] args) {
        
        // String 클래스
        // 1. 문자열은 배열이다.
        char str1 = '유';   // char타입 (' ')은 1글자만
        char[] str2 = {'유', '재', '석'};
        String str3 = "유재석"; // String 클래스는 멤버변수

        // 2. 문자 변환
        char str4 = 65; System.out.println(str4);   // A
        char[] str5 = {74, 65, 86, 65}; System.out.println(str5);
        char str6 = '유'; System.out.println((int)str6);    // 50976
        // 정수 -char(규칙)-> 문자 -배열-> 문자열
        // 3. 문자열 비교
        System.out.println("유재석" == "유재석");                         // true
        System.out.println(new String("유재석") == "유재석");   // false
        System.out.println(new String("유재석").equals("유재석"));  // true

        // 4. 문자열A.concat(문자열B), 문자열 연결, 연결된 새로운 문자열 반환 (주소값 생성)
        String str7 = "자바";   String str8 = "프로그래밍";
        System.out.println(str7.concat(str8));
        System.out.println(str7 + str8);

        // 5. StringBuilder, append(), 문자열은 불변이다. 빌더주소값은 1개지정하여 새로운 문자열을 생성
        StringBuilder builder = new StringBuilder();
        builder.append(str7);
        builder.append(str8);
        System.out.println(builder);

        // 6. chatAt(인덱스), 문자 1개 추출
        String str9 = "자바프로그래밍"; System.out.println(str9.charAt(2)); // 프

        // 7. length(): 문자열 낸 문자 개수 반환
        System.out.println(str9.length());
        
        // 8. replace(기존문자, 새로운문자) : 만일 기존문자가 존재하면 새로운 문자로 치환하여 반환
        System.out.println(str9.replace("자바", "JAVA"));

        // 9. substring(시작 인덱스, [끝인덱스]), 시작인덱스부터 끝인덱스전까지 문자열 추출
        String str10 = "991012-123242";
        System.out.println(str10.substring(6));
        System.out.println(str10.substring(0, 6));

        // 10. split(기준문자), 기준문자 기준으로 문자열 분해
        System.out.println(str10.split("-"));   // 새로운 주소값
        String[] strAry = str10.split("-");
        System.out.println(strAry[0] + strAry[1]);

        // 11. indexOf(찾을 문자), 만일 찾을문자가 존재하면 인덱스, 없으면 -1
        //      contains(찾을 문자), 만일 찾을문자가 존재하면 True, 없으면 false
        System.out.println("자바 프로그래밍 언어".indexOf("프로"));

        // 12. getBytes() , 문자열내 문자열들을 바이트 배열 반환 *파일처리/네트워크 등 외부통신"
        byte[] strAry2 = "ABC".getBytes();
        System.out.println(Arrays.toString(strAry2));
        System.out.println(new String(strAry2));

    }
}
