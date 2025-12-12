package com.operalatam.api.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.operalatam.api.dto.InputCreateSetorDTO;
import com.operalatam.api.model.Setor;
import com.operalatam.api.service.SetorService;

@RestController
@RequestMapping("/setores")
public class SetorController {

    private final SetorService setorService;

    public SetorController(SetorService setorService) {
        this.setorService = setorService;
    }

    @PostMapping
    public String createSetor(@RequestBody InputCreateSetorDTO setorDto) {
        // Map DTO to entity (keeps controller simple; service expects entity)
        Setor setor = new Setor();
        setor.setNome(setorDto.getNome());
        return setorService.createSetor(setor);
    }

    @DeleteMapping("/{id}")
    public void deleteSetor(@PathVariable Long id) {
        setorService.deleteSetor(id);
    }
}
