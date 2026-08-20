package day28;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice14 {
    static String carParkingList = "3,211가6231,202608190930\n8,452하1234,202608171227";
    static ArrayList<String> carArrayList = new ArrayList<>(List.of(carParkingList.split("\n")));
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("1.위치찾기 2.입차 3.출차 선택:");
            int ch = scan.nextInt();
            if( ch == 1 ){ findCarLocation();} // 위치찾기 구현 
            if( ch == 2 ){ addCar();} // 입차 구현 
            if( ch == 3 ){ exitCar(); } // 출차 구현
        }

    } 
    public static void findCarLocation(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("찾을 차량 번호: "); String carNumber = scanner.next();
        // 차량번호를 찾을 때 index 반환
        for (String arr: carArrayList){
            String[] carInfo = arr.split(",");
            if (carInfo[1].equals(carNumber)){{
                System.out.println(carInfo[0]);
                return;
            }}
        }
        System.out.println("미등록 차량");
    }

    public static void addCar(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력: location (위치번호), carNumber (차량번호), dateTime (입차일시)");
        String[] newCarInfo = scanner.next().split(",");

        for (String arr: carArrayList){
            String[] carInfo = arr.split(",");
            if (newCarInfo[0].equals(carInfo[0])){
                System.out.println("이미 주차되어 있는 위치 번호에는 중복 주차할 수 없습니다");
                return;
            }
        }
        carArrayList.add(newCarInfo[0] + "," +newCarInfo[1] + newCarInfo[2]);
        System.out.println(newCarInfo[0]);
    }

    public static void exitCar(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("찾을 차량 번호: "); String carNumber = scanner.next();
        
        for (String arr: carArrayList){
            String[] carInfo = arr.split(",");
            if (carInfo[1].equals(carNumber)){{ // 찾았을 때 출차 계산 함수
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime localDateTime = LocalDateTime.of(
                    Integer.parseInt(carInfo[2].substring(0, 4)),
                     Integer.parseInt(carInfo[2].substring(4, 6)),
                     Integer.parseInt(carInfo[2].substring(6, 8)),
                     Integer.parseInt(carInfo[2].substring(8, 10)),
                     Integer.parseInt(carInfo[2].substring(10, 12)));

                Duration duration = Duration.between(localDateTime, now);
                
                
                long days = duration.toDays();
                long hours = duration.toHours();
                long mins = duration.toMinutes();

                long price = 0;
                price += 20000*days;
                mins += hours*60;

                int dayPrice = 0;
                for (int i = 10; i < mins; i += 10){
                    if (dayPrice >= 20000) break;
                    dayPrice += 1000;
                }
                price += dayPrice;

                System.out.println("주차 가격: " + price);


                carArrayList.remove(arr);
                break;
            }}
        }
        
        
    }
}

/*
[ 문자열 실습 ] 타워 주차 관리 시스템 데이터 처리
1. 문제 개요
주차장 관제 시스템에서 관리 중인 차량 데이터(carParkingList)는 단일 String으로 관리되고 있습니다. 
이 데이터를 기반으로 입차, 출차, 내 차량 위치 찾기 기능을 구현하세요.
단) 새로운 클래스 만들지 않습니다.

2. 데이터 규격
데이터 구분자:
행(객체/차량) 구분: 줄바꿈 문자 (\n)
열(속성) 구분: 쉼표 (,)
컬럼 순서: 위치번호,차량번호,날짜시간(YYYYMMDDhhmm)

초기 데이터 예시:
String carParkingList = "3,211가6231,202608190930\n8,452하1234,202608171227";

3. 구현 요구사항
다음 세 기능 구현하세요. 
① 차량 위치 찾기 (findCarLocation)
기능: 차량 번호를 입력받아 현재 주차된 위치 번호를 반환합니다.
입력: carNumber (찾을 차량번호)
출력/반환:
차량이 존재할 경우: 주차 위치 번호 (예: "3")
차량이 없을 경우: "미등록 차량" 또는 -1 반환

② 입차 처리
기능: 새로운 차량의 주차 정보를 기존 데이터에 추가합니다.
조건:
이미 주차되어 있는 위치 번호에는 중복 주차할 수 없습니다
입력: location (위치번호), carNumber (차량번호), dateTime (입차일시)
출력/반환:
차량이 입차한 경우 : 주차 위치 번호 (예: "3")
차량이 입차가 없을 경우: 위치 번호에는 중복 주차할 수 없습니다. (위치 중복 시 입차 불가 메시지 출력)

③ 출차 처리
기능: 출차할 차량 번호를 입력받아 해당 차량의 행을 carParkingList에서 삭제합니다.
입력: carNumber (출차할 차량번호)
반환: 해당 차량이 제거되고 줄바꿈이 올바르게 정리된 갱신된 carParkingList 문자열
기본 정책: 최초 30분 무료추가 요금: 30분 초과 시, 10분당 1,000원 (10분 단위 절상/올림 계산)
예: 31분 ~ 40분 주차 -> 1,000원   
예: 41분 ~ 50분 주차 -> 2,000원
일일 최대 요금: 24시간(1일)당 최대 20,000원여러 날에 걸쳐 주차한 경우, 
각 일자 단위로 계산 후 합산하거나 총 일수×20,000원 + 잔여시간 요금(최대 20,000원)을 적용합니다.

*/