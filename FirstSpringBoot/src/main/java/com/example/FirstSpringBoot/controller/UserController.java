package com.example.FirstSpringBoot.controller;

import com.example.FirstSpringBoot.entity.User;
import com.example.FirstSpringBoot.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<User> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return repository.save(user);
    }
}