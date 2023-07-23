package com.bootcamp.testapi.service;

import com.bootcamp.testapi.dao.ProductDao;
import com.bootcamp.testapi.dto.ProductDto;
import com.bootcamp.testapi.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductDao dao;

    public void save(ProductDto.Save data){
        this.dao.save(data);
    }

    public List<Product> findAll(){
        return this.dao.findAll();
    }

    public Product findById(Integer id){
        return this.dao.findById(id).orElseThrow(()-> new RuntimeException("Product dengan id" + id + "tidak ditemukan."));
    }

    public void delete(Integer id){
        findById(id);
        this.dao.delete(id);
    }

    public void update(ProductDto.Save data, Integer id){
        findById(id);
        this.dao.update(data, id);
    }

}
