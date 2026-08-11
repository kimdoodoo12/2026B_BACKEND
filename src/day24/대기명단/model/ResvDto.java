package day24.대기명단.model;

public class ResvDto {
    String phone;
    int ppl;

    public ResvDto(){}

    public ResvDto(String phone, int ppl) {
        this.phone = phone;
        this.ppl = ppl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPpl() {
        return ppl;
    }

    public void setPpl(int ppl) {
        this.ppl = ppl;
    }

    @Override
    public String toString() {
        return "ResvDto [phone=" + phone + ", ppl=" + ppl + "]";
    }

}
