package com.example.FirstSpringBoot.service;

import com.example.FirstSpringBoot.repository.UserRepository;
import com.example.FirstSpringBoot.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    private final UserRepository repo;
    public UserService(UserRepository repo)
    {
        this.repo=repo;
    }

    public List<User> getAll()
    {
        return repo.findAll();
    }

    public ResponseEntity<User> create (@RequestBody User user){
        User createdUser = repo.save(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    public ResponseEntity<Void> delete (Long index)
    {
        if(repo.existsById(index))
        {
            repo.deleteById(index);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    public ResponseEntity<Object> getUserById(Long id)
    {
        Optional<User> user = repo.findById(id);
        if (user.isPresent())
        {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(Collections.emptyMap(),HttpStatus.NOT_FOUND);
    }
}

