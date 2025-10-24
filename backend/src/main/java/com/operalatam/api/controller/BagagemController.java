package com.operalatam.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.operalatam.api.model.Bagagem;
import com.operalatam.api.repository.BagagemRepository;


    @RestController
    @RequestMapping("/bagagens")
    public class BagagemController {

        @Autowired
        private BagagemRepository bagagemRepository;

        @PostMapping
        public Bagagem criarBagagem(@RequestBody Bagagem bagagem) {
            return bagagemRepository.save(bagagem);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletarBagagem(@PathVariable Long id) {
            if (!bagagemRepository.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            bagagemRepository.deleteById(id);
            return ResponseEntity.noContent().build();
    }
}

