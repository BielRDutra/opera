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

import com.operalatam.api.model.Box;
import com.operalatam.api.repository.BoxRepository;

@RestController
@RequestMapping("/boxes")
public class BoxController {
        
        @Autowired
        private BoxRepository boxRepository;

        @PostMapping("/{nome}")
        public Box criarBox(@RequestBody Box box) {
            return boxRepository.save(box);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Box> obterBox(@PathVariable Long id) {
            return boxRepository.findById(id)
                .map(box -> ResponseEntity.ok(box))
                .orElse(ResponseEntity.notFound().build());
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletarBox(@PathVariable Long id) {
            if (!boxRepository.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            boxRepository.deleteById(id);
            return ResponseEntity.noContent().build();
    }
}

