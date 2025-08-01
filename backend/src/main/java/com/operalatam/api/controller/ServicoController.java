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

import com.operalatam.api.model.Servico;
import com.operalatam.api.repository.ServicoRepository;


@RestController
@RequestMapping("/servicos")
public class ServicoController {
        
        @Autowired
        private ServicoRepository servicoRepository;

        @PostMapping("/{nome}")
        public Servico criarServico(@RequestBody Servico servico) {
            return servicoRepository.save(servico);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Servico> obterServico(@PathVariable Long id) {
            return servicoRepository.findById(id)
                .map(servico-> ResponseEntity.ok(servico))
                .orElse(ResponseEntity.notFound().build());
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletarServico(@PathVariable Long id) {
            if (!servicoRepository.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            servicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
    }
}