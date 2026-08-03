package day19;

public class Exam1 {
    public static void main(String[] args) {
        
        int temp = 5;
        
        char grade = 'B';
        int adult = 1;
        switch(grade){
            case 'A' : System.out.println("A등급"); break;
            case 'B' : System.out.println("B등급"); break;
            case 'C' : System.out.println("C등급"); break;
            case 'D' : System.out.println("재시험"); break;

        }

        switch (grade) {
            case 'A':
                switch (adult) {
                    case 1:
                        System.out.println("A등급 성인입니다.");
                        break;

                    case 2:
                        System.out.println("A등급 미성년자입니다.");
                        break;
                
                    default:
                        break;
                }
                break;
            case 'B':
                switch (adult) {
                    case 1:
                        System.out.println("B등급 성인입니다.");
                        break;

                    case 2:
                        System.out.println("B등급 미성년자입니다.");
                        break;
                
                    default:
                        break;
                }
            default:
                break;
        }

    }    
}
