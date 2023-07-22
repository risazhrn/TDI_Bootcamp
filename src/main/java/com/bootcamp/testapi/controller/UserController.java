package com.bootcamp.testapi.controller;

import com.bootcamp.testapi.dto.UsersDto;
import com.bootcamp.testapi.entity.Users;
import com.bootcamp.testapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    public ResponseEntity<List<Users>> findAll() {
        List<Users> users = this.service.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> findById(
            @PathVariable(name = "id") Integer id
    ) {
        Users user = this.service.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<String> save(
            @RequestBody UsersDto.Save data
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
            @RequestBody UsersDto.Save data,
            @PathVariable(name = "id") Integer id
    ) {
        this.service.update(data, id);
        return ResponseEntity.ok("Data berhasil diupdate.");
    }

}
