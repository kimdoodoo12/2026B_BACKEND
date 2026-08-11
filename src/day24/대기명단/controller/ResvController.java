package day24.대기명단.controller;

import java.util.ArrayList;

import day24.대기명단.model.ResvDao;
import day24.대기명단.model.ResvDto;

public class ResvController {
    private static final ResvController instance = new ResvController();
    public static ResvController getInstance(){return instance;}

    private ResvDao rd = ResvDao.getInstance();

    public boolean reserve(ResvDto resvDto){
        
        boolean result = rd.reserve(resvDto);

        return result;
    }

    public ArrayList<ResvDto> findAllResv(){
        
        ArrayList <ResvDto> result = rd.findAllResv();
        return result;
    }

    public boolean updateResv(ResvDto resvDto){

        boolean result = rd.updateResv(resvDto);
        return result;
    }

    public boolean deleteResv(ResvDto resvDto){
        boolean result = rd.deleteResv(resvDto);

        return result;
    }

}
