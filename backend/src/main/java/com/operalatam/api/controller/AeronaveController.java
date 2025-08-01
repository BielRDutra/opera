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

import com.operalatam.api.model.Aeronave;
import com.operalatam.api.repository.AeronaveRepository;

@RestController
@RequestMapping("/aeronaves")
    public class AeronaveController {
        
        @Autowired
        private AeronaveRepository aeronaveRepository;

        @PostMapping("/{nome}")
        public Aeronave criarAeronave(@RequestBody Aeronave aeronave) {
            return aeronaveRepository.save(aeronave);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Aeronave> obterAeronave(@PathVariable Long id) {
            return aeronaveRepository.findById(id)
                .map(aeronave -> ResponseEntity.ok(aeronave))
                .orElse(ResponseEntity.notFound().build());
        }

        @DeleteMapping("/{id}")

        public ResponseEntity<Void> deletarAeronave(@PathVariable Long id) {
            if (!aeronaveRepository.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            aeronaveRepository.deleteById(id);
            return ResponseEntity.noContent().build();
    }
}

