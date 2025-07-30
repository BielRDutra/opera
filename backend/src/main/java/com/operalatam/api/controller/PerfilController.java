package com.operalatam.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.operalatam.api.model.Perfil;
import com.operalatam.api.repository.PerfilRepository;


    @RestController
    @RequestMapping("/funcionarios")
    public class PerfilController {

        @Autowired
        private PerfilRepository perfilRepository;

        @PostMapping
        public Perfil criarPerfil(@RequestBody Perfil perfil) {
            return perfilRepository.save(perfil);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id) {
            if (!perfilRepository.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            perfilRepository.deleteById(id);
            return ResponseEntity.noContent().build();
    }
}
