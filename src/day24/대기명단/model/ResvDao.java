package day24.대기명단.model;
import java.util.*;

public class ResvDao {

    private static final ResvDao instance = new ResvDao();
    public static ResvDao getInstance(){return instance;}

    private ArrayList <ResvDto> resvList =  new ArrayList<>();


    public boolean reserve(ResvDto resvDto){
        resvList.add(resvDto);
        return true;
    }

    public ArrayList<ResvDto> findAllResv(){
        return resvList;
    }

    public boolean updateResv(ResvDto resvDto){
        for (int index = 0; index < resvList.size(); index++){
            if (resvList.get(index).getPhone().equals(resvDto.getPhone())){
                resvList.set( index, resvDto);
                return true;
            }
        }
            return false;

    }

    public boolean deleteResv(ResvDto resvDto){
        for (int index = 0; index < resvList.size(); index++){
            if (resvList.get(index).getPhone().equals(resvDto.getPhone())){
                resvList.remove(index);
                return true;
            }
        }
        return false;
    }

}
