package com.bootcamp.testapi.controller;

import com.bootcamp.testapi.dto.ProductDto;
import com.bootcamp.testapi.entity.Product;
import com.bootcamp.testapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = this.service.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(
            @PathVariable(name = "id") Integer id
    ) {
        Product product = this.service.findById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<String> save(
            @RequestBody ProductDto.Save data
    ) {
        this.service.save(data);
        return ResponseEntity.ok("Data berhasil diinsert!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Integer id
    ) {
        this.service.delete(id);
        return ResponseEntity.ok("Data berhasil dihapus.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(
            @RequestBody ProductDto.Save data,
            @PathVariable(name = "id") Integer id
    ) {
        this.service.update(data, id);
        return ResponseEntity.ok("Data berhasil diupdate.");
    }
}
