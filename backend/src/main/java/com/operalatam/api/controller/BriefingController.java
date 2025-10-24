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

import com.operalatam.api.model.Briefing;
import com.operalatam.api.repository.BriefingRepository;

    @RestController
    @RequestMapping("/briefings")
    public class BriefingController {

        @Autowired
        private BriefingRepository briefingRepository;

        @PostMapping
        public Briefing criarBriefing(@RequestBody Briefing briefing) {
            return briefingRepository.save(briefing);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Briefing> obterBriefing(@PathVariable Long id) {
            return briefingRepository.findById(id)
                .map(briefing -> ResponseEntity.ok(briefing))
                .orElse(ResponseEntity.notFound().build());
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletarBriefing(@PathVariable Long id) {
            if (!briefingRepository.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            briefingRepository.deleteById(id);
            return ResponseEntity.noContent().build();
    }
}
