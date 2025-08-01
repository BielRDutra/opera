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

import com.operalatam.api.model.Configuracao;
import com.operalatam.api.repository.ConfiguracaoRepository;

@RestController
@RequestMapping("/configuracoes")
public class ConfiguracaoController {
        
        @Autowired
        private ConfiguracaoRepository configuracaoRepository;

        @PostMapping("/{nome}")
        public Configuracao criarConfiguracao(@RequestBody Configuracao configuracao) {
            return configuracaoRepository.save(configuracao);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Configuracao> obterConfiguracao(@PathVariable Long id) {
            return configuracaoRepository.findById(id)
                .map(configuracao -> ResponseEntity.ok(configuracao))
                .orElse(ResponseEntity.notFound().build());
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletarConfiguracao(@PathVariable Long id) {
            if (!configuracaoRepository.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            configuracaoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
    }
}