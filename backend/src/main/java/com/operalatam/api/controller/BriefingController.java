package com.operalatam.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.operalatam.api.model.Briefing;
import com.operalatam.api.repository.BriefingRepository;

    @RestController
    @RequestMapping("/briefings")
    public class BriefingController {

        @Autowired
        private BriefingRepository briefingRepository;

        @PostMapping
        public Briefing criarFuncionario(@RequestBody Briefing briefing) {
            return briefingRepository.save(briefing);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id) {
            if (!briefingRepository.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            briefingRepository.deleteById(id);
            return ResponseEntity.noContent().build();
    }
}
