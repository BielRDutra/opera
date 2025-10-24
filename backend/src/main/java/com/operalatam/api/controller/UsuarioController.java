package com.operalatam.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.operalatam.api.model.Usuario;
import com.operalatam.api.repository.UsuarioRepository;


    @RestController
    @RequestMapping("/usuarios")
    public class UsuarioController {

        @Autowired
        private UsuarioRepository usuarioRepository;

        @PostMapping
        public Usuario criarUsuario(@RequestBody Usuario usuario) {
            return usuarioRepository.save(usuario);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
            if (!usuarioRepository.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            usuarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
    }
}

