package com.example.FirstSpringBoot.service;

import com.example.FirstSpringBoot.repository.PokemonRepository;
import com.example.FirstSpringBoot.entity.Pokemon;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Service
public class PokemonService
{
    private final PokemonRepository repo;

    public PokemonService (PokemonRepository repo)
    {
        this.repo=repo;
    }

    public List<Pokemon> getAll()
    {
        return repo.findAll();
    }

    public ResponseEntity<Pokemon> create (@RequestBody Pokemon pokemon) throws URISyntaxException {
        URI uri = new URI("localhost:8080/users");
        repo.save(pokemon);
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
    public Optional<Pokemon> getPokemonById(Long id)
    {
        return repo.findById(id);
    }

    public ResponseEntity<Void> deleteAll ()
    {
        repo.deleteAll();
        return ResponseEntity.noContent().build();
    }
}

