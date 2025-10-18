package com.operalatam.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.operalatam.api.model.Matricula;
import com.operalatam.api.repository.MatriculaRepository;


@RestController
@RequestMapping("/matriculas")
public class MatriculaController {
        
        @Autowired
        private MatriculaRepository matriculaRepository;

        @PostMapping("/{nome}")
        public Matricula criarMatricula(@RequestBody Matricula matricula) {
            return matriculaRepository.save(matricula);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Matricula> obterMatricula(@PathVariable Long id) {
            return matriculaRepository.findById(id)
                .map(matricula -> ResponseEntity.ok(matricula))
                .orElse(ResponseEntity.notFound().build());
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletarMatricula(@PathVariable Long id) {
            if (!matriculaRepository.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            matriculaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
    }
}