package day16;

public class Exam2 {
    
    public static void main(String[] args) {
        
        boolean bool1 = true; // let/const --> boolean
        System.out.println(bool1);

        char ch1 = 'A';
        System.out.println(ch1);

        String str1 = "HELLO";
        System.out.println(str1);

        byte b1 = 100; // 1 byte
        System.out.println(b1);

        short sh1 = 30000; // 2byte
        System.out.println(sh1);

        int i1 = 2000000000;  // 4byte
        System.out.println(i1);

        // 8byte, 정수는 int이므로 L 또는 l을 붙인다.
        long l1 = 2000000000000000000L; 
        System.out.println(l1);

        // 소수점 8자리 표현, 4byte
        // 입력한 실수는 double이므로 F/f를 붙인다.
        float f1 = 0.1123131232326474f;
        System.out.println(f1);

        // 소수점 17자리 표현, 8byte
        double d1 = 0.123123123123123123213;
        System.out.println(d1);
    }
}
