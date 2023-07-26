package com.bootcamp.testapi.service;

import com.bootcamp.testapi.dao.CategoryDao;
import com.bootcamp.testapi.dto.CategoryDto;
import com.bootcamp.testapi.entity.Category;
import com.bootcamp.testapi.exception.IdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryDao dao;

    public void save(CategoryDto.Save data){
        this.dao.save(data);
    }

    public List<Category> findAll(){
        return this.dao.findAll();
    }

    public Category findById(Integer id){
        return this.dao.findById(id).orElseThrow(() -> new IdNotFoundException("Category dengan id " + id + " tidak ditemukan."));
    }

    public void delete(Integer id){
        findById(id);
        this.dao.delete(id);
    }

    public void update(CategoryDto.Update data , Integer id){
        findById(id);
        this.dao.update(data, id);
    }
}
