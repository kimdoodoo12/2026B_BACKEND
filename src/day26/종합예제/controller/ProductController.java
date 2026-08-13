package day26.종합예제.controller;

import java.util.ArrayList;

import day26.종합예제.model.dao.IBaseDao;
import day26.종합예제.model.dao.ProductDao;
import day26.종합예제.model.dto.ProductDto;

public class ProductController {
    private ProductController() {}
    private static final ProductController instance = new ProductController();
    public static ProductController getInstance() { return instance; }

    private IBaseDao ib = ProductDao.getInstance();

    public boolean save(ProductDto productDto) {
        // TODO 1: productDto 전달받아 DAO의 save()를 호출하고 결과 반환
        boolean result = ib.save(productDto);
        return result;
    }

    public ArrayList<ProductDto> findAll() {
        // TODO 2: DAO의 findAll() 호출하여 결과를 받고 반환
        ArrayList<Object> objList = ib.findAll();
        ArrayList<ProductDto> result = new ArrayList<>();
        for(Object obj: objList){
            result.add((ProductDto)obj);
        }
        return result;
    }
}