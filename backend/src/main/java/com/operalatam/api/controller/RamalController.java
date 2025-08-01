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

import com.operalatam.api.model.Ramal;
import com.operalatam.api.repository.RamalRepository;




@RestController
@RequestMapping("/ramais")
    public class RamalController {
        
        @Autowired
        private RamalRepository ramalRepository;

        @PostMapping("/{nome}")
        public Ramal criarRamal(@RequestBody Ramal ramal) {
            return ramalRepository.save(ramal);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Ramal> obterRamal(@PathVariable Long id) {
            return ramalRepository.findById(id)
                .map(ramal -> ResponseEntity.ok(ramal))
                .orElse(ResponseEntity.notFound().build());
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletarRamal(@PathVariable Long id) {
            if (!ramalRepository.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            ramalRepository.deleteById(id);
            return ResponseEntity.noContent().build();
    }
}