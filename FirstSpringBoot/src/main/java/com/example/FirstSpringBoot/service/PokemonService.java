package com.example.FirstSpringBoot.service;

import com.example.FirstSpringBoot.entity.Pokemon;
import com.example.FirstSpringBoot.repository.PokemonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PokemonService
{
    private final PokemonRepository repo;
    public PokemonService(PokemonRepository repo)
    {
        this.repo=repo;
    }

    public List<Pokemon> getAll()
    {
            return repo.findAll();
    }

    public ResponseEntity<Pokemon> create (@RequestBody Pokemon pokemon){
        Pokemon createdPokemon = repo.save(pokemon);
        return new ResponseEntity<>(createdPokemon, HttpStatus.CREATED);
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
    public ResponseEntity<Object> getPokemonById(Long id)
    {
        Optional<Pokemon> pokemon = repo.findById(id);
        if (pokemon.isPresent())
        {
            return new ResponseEntity<>(pokemon.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(Collections.emptyMap(),HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Object> getFromOffset(int offset)
    {
        int id;
        ArrayList<Pokemon> pokemonList= (ArrayList<Pokemon>) getAll();
        ArrayList<Pokemon> selectedPokemon= new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            id=i+offset;
            if (id>=pokemonList.size())
            {
                break;
            }
            else
            {
                selectedPokemon.add(pokemonList.get(id));
            }
        }
        return new ResponseEntity<>(selectedPokemon, HttpStatus.OK);
    }
    public ResponseEntity<Integer> getSize()
    {
        return new ResponseEntity<>(repo.findAll().size(), HttpStatus.OK );
    }

    public ResponseEntity<Void> deleteAll()
    {
        repo.deleteAll();
        return ResponseEntity.noContent().build();
    }
}

