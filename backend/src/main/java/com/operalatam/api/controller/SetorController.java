package com.operalatam.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.operalatam.api.model.Setor;
import com.operalatam.api.repository.SetorRepository;

@RestController
@RequestMapping("/setores")
public class SetorController {

    @Autowired
    private SetorRepository setorRepository;

    @PostMapping("/{nome}")
    public Setor createSetor(@RequestBody Setor setor) {
        return setorRepository.save(setor);
    }

    @DeleteMapping("/{id}")
    public void deleteSetor(@PathVariable Long id) {
        setorRepository.deleteById(id);
    }
}
