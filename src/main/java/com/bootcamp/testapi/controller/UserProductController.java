package com.bootcamp.testapi.controller;

import com.bootcamp.testapi.dto.UserProductDto;
import com.bootcamp.testapi.entity.UserProduct;
import com.bootcamp.testapi.service.UserProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-product")
@RequiredArgsConstructor
public class UserProductController {
    private final UserProductService service;

    @GetMapping
    public ResponseEntity<List<UserProduct>> findAll() {
        List<UserProduct> userProducts = this.service.findAll();
        return ResponseEntity.ok(userProducts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProduct> findById(
            @PathVariable(name = "id") Integer id
    ) {
        UserProduct userProduct = this.service.findById(id);
        return ResponseEntity.ok(userProduct);
    }

    @PostMapping
    public ResponseEntity<String> save(
            @RequestBody UserProductDto.Save data
    ) {
        this.service.save(data);
        return ResponseEntity.ok("data berhasil diinsert!");
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
            @RequestBody UserProductDto.Save data,
            @PathVariable(name = "id") Integer id
    ) {
        this.service.update(data, id);
        return ResponseEntity.ok("Data berhasil diupdate.");
    }

}
