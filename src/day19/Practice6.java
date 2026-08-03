package day19;

import java.util.Arrays;
import java.util.Scanner;

public class Practice6 {
    public static void main(String[] args) {

Scanner scanner = new Scanner(System.in);
/*[문제 1] 정수 5개(10, 20, 30, 40, 50)를 저장할 수 있는 int 타입의 배열 numbers1를 선언과 동시에 초기화하세요.
배열의 2번 인덱스에 저장된 값을 콘솔에 출력하세요.*/

int [] numbers1 = {10, 20, 30, 40, 50};
System.out.println(numbers1[2]);

/*[문제 2] String 타입의 데이터를 3개 저장할 수 있는 배열 season을 new 키워드를 사용하여 생성하세요.
각 인덱스에 "봄", "여름", "가을" 값을 순서대로 할당하세요.
Arrays.toString()을 사용하여 배열의 모든 요소를 한 번에 출력하세요.*/

String[] season = new String [3];
season[0] = "봄"; season[1] = "여름"; season[2] = "가을";
System.out.println(Arrays.toString(season));

/*[문제 3] 다음과 같은 과일 배열이 있습니다. for 반복문을 사용하여 배열의 모든 요소를 하나씩 콘솔에 출력하시오.
선언 코드: String[] fruits = {"사과", "바나나", "포도", "딸기"};*/
String[] fruits = {"사과", "바나나", "포도", "딸기"};
for (String data: fruits){
    System.out.println(data);
}

/*[문제 4] 다음 학생들의 점수가 담긴 배열이 있습니다. for 반복문을 사용하여 모든 점수의 합계와 평균을 계산하여 콘솔에 출력하시오.
요구 조건: 평균은 소수점까지 정확하게 계산되어야 합니다.
선언 코드: int[] scores1 = {85, 92, 78, 65, 95};*/
int[] scores1 = {85, 92, 78, 65, 95};
int total = 0;
for (int i: scores1){
    total += i;
}
System.out.println(total); System.out.println(total/scores1.length);

/*[문제 5] 점수 배열에서 100점 만점자가 처음 나타나면, "100점 만점자를 찾았습니다!"라고 출력하고 반복문을 즉시 종료하는 프로그램을 작성하시오.
선언 코드: int[] scores2 = {77, 82, 100, 54, 96};*/
int[] scores2 = {77, 82, 100, 54, 96};
for (int data: scores2){
    if (data == 100){
        System.out.println("100점 만점자를 찾았습니다!");
        break;
    }
}

/*[문제 6] 다음 배열에서 'A'형 혈액형을 가진 사람이 몇 명인지 for 반복문을 통해 세고, 그 수를 콘솔에 출력하시오.
선언 코드: String[] bloodTypes = {"A", "B", "O", "AB", "A", "B", "A"};*/

String[] bloodTypes = {"A", "B", "O", "AB", "A", "B", "A"};
int bloods = 0;
for (String data: bloodTypes){
    bloods++;
}
System.out.println(bloods);

/*[문제 7] 주어진 숫자 배열에서 가장 큰 값을 찾아 콘솔에 출력하는 프로그램을 작성하시오.
선언 코드: int[] numbers2 = {23, 5, 67, 12, 88, 34};*/

int[] numbers2 = {23, 5, 67, 12, 88, 34};
int max = 0;
for (int i: numbers2){
    if (i > max) {max = i;}
}
System.out.println(max);

/*[문제 8] products(상품 목록)와 stock(재고 수량) 배열이 있습니다. (*상품명과 재고수량 인덱스가 같다는 가정 )
Scanner를 이용해 사용자로부터 구매할 상품명과 수량을 입력받아, 재고가 충분하면 "구매 완료!"를 출력하고 재고를 차감하세요.
재고가 부족하면 "재고가 부족합니다."를, 없는 상품이면 "없는 제품명입니다."를 출력합니다.
선언 코드:
String[] products = {"볼펜", "노트", "지우개"};
int[] stock = {10, 5, 20};*/
String[] products = {"볼펜", "노트", "지우개"};
int[] stock = {10, 5, 20};

System.out.println("볼펜, 노트, 지우개중 하나를 고르시오"); String item = scanner.next();
System.out.println("개수: "); int amount = scanner.nextInt();

for (int index = 0; index < products.length; index++){
    if (products[index].equals(item)){
        stock[index] -= amount;
        System.out.println("구매완료!");
        break;
    }
    else if (index == products.length-1){
        System.out.println("없는 제품명입니다.");
    }
}



/*[문제 9] 주어진 영화 이름과 평점 배열을 이용하여, 각 영화의 평점을 별(★, ☆)로 시각화하여 출력하는 프로그램을 작성하시오.(* 영화명과 평점 인덱스가 같다는 가정 )
요구 조건: 각 영화의 평점(10점 만점)만큼 꽉 찬 별(★)을, 나머지 점수만큼 빈 별(☆)을 출력합니다.
예시: 평점이 8점이면 ★★★★★★★★☆☆ (총 10개의 별)
선언 코드:
String[] movieNames = {"히든페이스", "위키드", "글래디에이터2", "청설"};
int[] movieRatings = {8, 4, 7, 6};
출력 예시:
히든페이스 ★★★★★★★★☆☆
위키드 ★★★★☆☆☆☆☆☆
글래디에이터2 ★★★★★★★☆☆☆
청설 ★★★★★★☆☆☆☆*/

String[] movieNames = {"히든페이스", "위키드", "글래디에이터2", "청설"};
int[] movieRatings = {8, 4, 7, 6};
for (int index = 0; index < movieNames.length; index++){
    for (int j = 0; j < movieRatings[index]; j++){
        System.out.print("★");
    }
    for (int j = 0; j < 10 - movieRatings[index]; j++){
        System.out.print("☆");
    }
    System.out.println();
}

/*[문제 10] 차량별 주차 시간 데이터가 주어졌을 때, 아래의 요금 규정에 따라 각 차량이 지불해야 할 최종 주차 요금을 계산하여 출력하시오.(* 차량번호 와 이용시간 인덱스가 같다는 가정 )
요금 규정:
기본 요금: 최초 30분까지 1,000원
추가 요금: 30분 초과 시, 매 10분마다 500원씩 추가
일일 최대 요금: 20,000원 (아무리 오래 주차해도 20,000원을 초과할 수 없음)
선언 코드:
String[] carNumbers = {"210어7125", "142가7415", "888호8888", "931나8234"};
int[] usageMinutes = {65, 30, 140, 420};
출력 예시:
210어7125: 65분 주차, 최종 요금: 2500원
142가7415: 30분 주차, 최종 요금: 1000원
888호8888: 140분 주차, 최종 요금: 6500원
931나8234: 420분 주차, 최종 요금: 20000원*/

String[] carNumbers = {"210어7125", "142가7415", "888호8888", "931나8234"};
int[] usageMinutes = {65, 30, 140, 420};

for (int index = 0; index <= carNumbers.length-1; index++){
    System.out.print(carNumbers[index] + ": ");

    System.out.print(usageMinutes[index] + "분 주차, ");

    int fee = 0;
    if (usageMinutes[index] > 30){
        fee += 1000;
        fee += (usageMinutes[index]- 30) / 10 * 500;
        System.out.print("최종요금: " + fee + "원");
        if (fee >= 20000){
            fee = 20000;
            System.out.print("최종요금: " + fee + "원");
            break;
        }
    }
}

    }
}
