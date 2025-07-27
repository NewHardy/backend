package com.example.FirstSpringBoot.service;

import com.example.FirstSpringBoot.repository.UserRepository;
import com.example.FirstSpringBoot.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.net.URISyntaxException;
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

    public ResponseEntity<User> create (@RequestBody User user) throws URISyntaxException {
        URI uri = new URI("localhost:8080/users");
        repo.save(user);
        return ResponseEntity.created(uri).build();
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
    public Optional<User> getUserById(Long id)
    {
         return repo.findById(id);
    }
}

