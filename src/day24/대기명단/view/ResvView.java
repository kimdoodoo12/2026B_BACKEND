package day24.대기명단.view;

import java.util.*;

import day24.대기명단.controller.ResvController;
import day24.대기명단.model.ResvDao;
import day24.대기명단.model.ResvDto;

public class ResvView {
    private static final ResvView instance = new ResvView();
    public static ResvView getInstance() {return instance;}

    public ResvController rc = ResvController.getInstance();

    Scanner scanner = new Scanner(System.in);
    public void run(){
        
        while(true){
            System.out.println("============= Reservation =============");
            System.out.println("  1.예약 | 2.전체예약 조회 | 3. 예약 수정 | 4. 예약 삭제  ");
            System.out.println("========================================");

            System.out.print("선택 > "); int ch = scanner.nextInt();

            System.out.println();
            if (ch == 1){
                reserve();
            }
            else if (ch == 2){
                findAllResv();
            }
            else if (ch == 3){
                updateResv();
            }
            else if (ch == 4){
                deleteResv();
            }
            else{
                return;
            }

        }
    }

    public void reserve(){
        System.out.print("전화번호: "); String phone = scanner.next();
        System.out.print("인원수: "); int ppl = scanner.nextInt();
        ResvDto resvDto = new ResvDto(phone, ppl);
        boolean result = rc.reserve(resvDto);

        if (result){ System.out.println("예약 성공!");}
        else {System.out.println("예약실패");}
    }

    public void findAllResv(){

        ArrayList <ResvDto> result = rc.findAllResv();
        for (ResvDto resvDto: result){
            System.out.println("전화번호: " + resvDto.getPhone() + ", 인원수: " + resvDto.getPpl());
        }
    }

    public void updateResv(){

        System.out.print("전화번호: "); String phone = scanner.next();
        System.out.print("인원수 변경:"); int ppl = scanner.nextInt();
        ResvDto resvDto = new ResvDto(phone, ppl);
        boolean result = rc.updateResv(resvDto);

        if (result){System.out.println("예약 변경완료");}
        else {System.out.println("에약 실패");}
    }

    public void deleteResv(){
        System.out.print("전화번호: "); String phone = scanner.next();
        
        ResvDto resvDto = new ResvDto(); resvDto.setPhone(phone);

        boolean result = rc.deleteResv(resvDto);

        if (result){ System.out.println("예약 삭제 성공!");}
        else{System.out.println("삭제 실패!");}
    }


}
