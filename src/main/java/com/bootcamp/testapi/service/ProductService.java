package com.bootcamp.testapi.service;

import com.bootcamp.testapi.dao.ProductDao;
import com.bootcamp.testapi.dto.ProductDto;
import com.bootcamp.testapi.entity.Product;
import com.bootcamp.testapi.exception.IdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductDao dao;
    private final CategoryService categoryService;

    public void save(ProductDto.Save data){
        categoryService.findById(data.getCategory_id());
        this.dao.save(data);
    }

    public List<Product> findAll(){
        return this.dao.findAll();
    }

    public Product findById(Integer id){
        return this.dao.findById(id).orElseThrow(()-> new IdNotFoundException("Product dengan id" + id + "tidak ditemukan."));
    }

    public void delete(Integer id){
        findById(id);
        this.dao.delete(id);
    }

    public void update(ProductDto.Update data, Integer id){
        findById(id);
        this.dao.update(data, id);
    }

}
