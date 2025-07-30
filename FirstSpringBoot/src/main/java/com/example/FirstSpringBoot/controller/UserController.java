package com.example.FirstSpringBoot.controller;

import com.example.FirstSpringBoot.entity.User;
import com.example.FirstSpringBoot.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        return service.create(user);
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<Void> delete (@PathVariable Long index) {
        return service.delete(index);
    }

    @GetMapping("/{index}")
    public ResponseEntity<Object> getById(@PathVariable Long index)
    {
        return service.getUserById(index);
    }
}