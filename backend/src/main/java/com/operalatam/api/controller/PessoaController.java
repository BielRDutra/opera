package com.operalatam.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.operalatam.api.model.Pessoa;
import com.operalatam.api.repository.PessoaRepository;


    @RestController
    @RequestMapping("/pessoas")
    public class PessoaController {

        @Autowired
        private PessoaRepository pessoaRepository;

        @PostMapping("/{nome}")
        public ResponseEntity<Pessoa> createPessoa(@RequestBody Pessoa pessoa) {
            Pessoa savedPessoa = pessoaRepository.save(pessoa);
            return ResponseEntity.ok(savedPessoa);
        }
        
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletePessoa(@PathVariable Long id) {
            if (!pessoaRepository.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            pessoaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }
