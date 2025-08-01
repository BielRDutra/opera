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

import com.operalatam.api.model.Portao;
import com.operalatam.api.repository.PortaoRepository;

@RestController
@RequestMapping("/portoes")
public class PortaoController {
        
        @Autowired
        private PortaoRepository portaoRepository;

        @PostMapping("/{nome}")
        public Portao criarPortao(@RequestBody Portao portao) {
            return portaoRepository.save(portao);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Portao> obterPortao(@PathVariable Long id) {
            return portaoRepository.findById(id)
                .map(portao -> ResponseEntity.ok(portao))
                .orElse(ResponseEntity.notFound().build());
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletarPortao(@PathVariable Long id) {
            if (!portaoRepository.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            portaoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
    }
}
