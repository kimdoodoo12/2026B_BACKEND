package day26.종합예제.model.dto;

public class ProductDto extends BaseTime {
    private String name;
    private int price;

    public ProductDto() {
        super();
    }

    public ProductDto(String name, int price) {
        super();
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    @Override
    public String toString() {
        return "ProductDto [name=" + name + ", price=" + price + ", cdate=" + getCdate() + "]";
    }
}