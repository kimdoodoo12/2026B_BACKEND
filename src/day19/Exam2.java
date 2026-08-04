package day19;

import java.util.Arrays;
import java.util.Scanner;

public class Exam2 {
    

public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int[] array = new int[0];

    while(true){
        System.out.println("1. 요소추가 | 2.인덱스로 삭제 | 0. 종료");
        int input = scanner.nextInt();

        if (input == 1){
            System.out.print("추가할 정수를 입력하세요: ");
            int temp = scanner.nextInt();
            int[] array2 = new int[array.length+1];
            for (int index=0; index<array.length; index++){
                array2[index] = array[index];
            }
            array2[array2.length-1] = temp;
            array = array2;
            System.out.println(temp + "가 성공적으로 추가 되었습니다.");
            System.out.println(Arrays.toString(array));
        }

        else if (input == 2){
            System.out.print("삭제할 인덱스를 입력하세요: ");
            int temp = scanner.nextInt();
            int[] array2 = new int[array.length-1];

            for (int index=0; index < temp; index++){
                array2[index] = array[index];
            }
            for (int index=temp; index < array2.length; index++){
                array2[index] = array[index+1];
            }
            System.out.println("인덱스(" + temp + ")의 값 ("+ array[temp] + ")이 삭제되었습니다.");
            array = array2;
            System.out.println(Arrays.toString(array));

        }

        else if (input == 0){return;}
    }
    

}   
}
