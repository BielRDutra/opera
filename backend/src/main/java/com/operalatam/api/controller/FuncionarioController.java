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

import com.operalatam.api.model.Funcionario;
import com.operalatam.api.repository.FuncionarioRepository;

    @RestController
    @RequestMapping("/funcionarios")
    public class FuncionarioController {

        @Autowired
        private FuncionarioRepository funcionarioRepository;

        @PostMapping
        public Funcionario criarFuncionario(@RequestBody Funcionario funcionario) {
            return funcionarioRepository.save(funcionario);
        }
        @GetMapping("/{id}")
        public ResponseEntity<Funcionario> obterFuncionario(@PathVariable Long id) {
            return funcionarioRepository.findById(id)
                .map(funcionario -> ResponseEntity.ok(funcionario))
                .orElse(ResponseEntity.notFound().build());
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id) {
            if (!funcionarioRepository.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            funcionarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
    }
}
