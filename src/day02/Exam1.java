package day02;

public class Exam1 {
    
    public static void main(String[] args) {

        // 다형성

        // [1] 자동 (묵시적) 타입 변환: byte -> short -> int -> long -> float -> double 

        byte bytevalue = 100;
        short shortvalue = bytevalue;
        int intvalue = shortvalue;
        long longvalue = intvalue;
        double doublevalue = longvalue;


        // 연산 중에 자동 타입변환, byte/short 연산결과 => int()
        byte b1 = 10; byte b2 = 20; short s1 = 30; int i1 = 40; long l1 = 50l; float f1 = 60.1f; double d1 = 70.2;

        int result1 = b1 + b2; // byte + byte = short
        int result2 = b1 + s1; // byte + short = short
        int result3 = i1 + i1; // int + int = int
        long result4 = i1 + l1; // int + long = long
        float result5 = i1 + f1; // int + float = float
        double result6 = i1 + d1; // int + double = double

        // 2 강제(명시적) 타입 변환, byte <- short <- int <- long <- float <- dobule, 큰 것 -> 작은것, "자료손실"
        
        double dvalue = 3.14;
        float fvalue = (float)dvalue;
        long lvalue = (long)fvalue;
        int ivalue = (int)lvalue;
        short svalue = (short)ivalue;
        byte bvalue = (byte)svalue;







    }
}
