package com.operalatam.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.operalatam.api.model.Setor;
import com.operalatam.api.repository.SetorRepository;

@RestController
@RequestMapping("/setores")
public class SetorController {

    @Autowired
    private SetorRepository setorRepository;

    @PostMapping
    public Setor createSetor(@RequestBody Setor setor) {
        return setorRepository.save(setor);
    }

    @DeleteMapping("/{id}")
    public void deleteSetor(@PathVariable Long id) {
        setorRepository.deleteById(id);
    }
}
