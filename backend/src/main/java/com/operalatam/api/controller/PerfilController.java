package com.operalatam.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.operalatam.api.model.Perfil;
import com.operalatam.api.repository.PerfilRepository;


    @RestController
    @RequestMapping("/perfis")
    public class PerfilController {

        @Autowired
        private PerfilRepository perfilRepository;

        @PostMapping
        public Perfil criarPerfil(@RequestBody Perfil perfil) {
            return perfilRepository.save(perfil);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletarPerfil(@PathVariable Long id) {
            if (!perfilRepository.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            perfilRepository.deleteById(id);
            return ResponseEntity.noContent().build();
    }
}
