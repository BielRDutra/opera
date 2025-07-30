package com.operalatam.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.operalatam.api.model.Pessoa;
import com.operalatam.api.repository.PessoaRepository;


    @RestController
    @RequestMapping("/funcionarios")
    public class PessoaController {

        @Autowired
        private PessoaRepository pessoaRepository;

        @PostMapping
        public Pessoa criarFuncionario(@RequestBody Pessoa pessoa) {
            return pessoaRepository.save(pessoa);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id) {
            if (!pessoaRepository.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            pessoaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
    }
}
