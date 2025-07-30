package com.operalatam.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id) {
            if (!funcionarioRepository.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            funcionarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
    }
}
