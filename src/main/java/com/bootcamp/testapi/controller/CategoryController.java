package com.bootcamp.testapi.controller;

import com.bootcamp.testapi.dto.CategoryDto;
import com.bootcamp.testapi.entity.Category;
import com.bootcamp.testapi.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = this.service.findAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable(name = "id") Integer id) {
        Category category = this.service.findById(id);
        return ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> save(
            @RequestBody @Valid CategoryDto.Save data, BindingResult result
    ) {
        Map<String, Object> output = new HashMap<>();
        if (result.hasErrors()) {
            Map<String, Object> errors = new HashMap<>();
            for (FieldError fieldError : result.getFieldErrors()) {
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            output.put("status", errors);
            return ResponseEntity.badRequest().body(output);
        }
        this.service.save(data);
        output.put("status", "Berhasil menambah category");
        return ResponseEntity.ok(output);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        this.service.delete(id);
        return ResponseEntity.ok("Data berhasil dihapus.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(
            @PathVariable(name = "id") Integer id,
            @RequestBody @Valid CategoryDto.Update data,
            BindingResult result
    ) {
        Map<String, Object> output = new HashMap<>();
        if (result.hasErrors()) {
            Map<String, Object> errors = new HashMap<>();
            for (FieldError fieldError : result.getFieldErrors()) {
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            output.put("status", errors);
            return ResponseEntity.badRequest().body(output);
        }
        this.service.update(data, id);
        output.put("status", "Data berhasil diupdate.");
        return ResponseEntity.ok(output);
    }
}
