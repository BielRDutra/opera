package com.operalatam.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.operalatam.api.model.Genero;
import com.operalatam.api.repository.GeneroRepository;
import java.util.Optional;


@RestController
@RequestMapping("/generos")
public class GeneroController {

    @Autowired
    private GeneroRepository generoRepository;

    @PostMapping("/{nome}")
    public ResponseEntity<Genero> criarGenero(@RequestBody Genero genero) {
        Genero salvo = generoRepository.save(genero);
        return ResponseEntity.ok(salvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarGenero(@PathVariable Long id) {
        Optional<Genero> genero = generoRepository.findById(id);
        if (genero.isPresent()) {
            generoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
