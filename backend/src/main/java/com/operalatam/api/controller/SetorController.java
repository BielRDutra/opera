package com.operalatam.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.operalatam.api.dto.InputCreateSetorDTO;
import com.operalatam.api.dto.ListSetoresRequestDTO;
import com.operalatam.api.dto.SetorResponseDTO;
import com.operalatam.api.dto.SetorResultDTO;
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
    public ResponseEntity<?> createSetor(@RequestBody InputCreateSetorDTO setorDto) {
        String nome = setorDto.getNome();
        if (nome == null || nome.isBlank()) {
            return ResponseEntity.badRequest()
                    .body(new SetorResultDTO(false, "Nome deve ser informado"));
        }

        // check duplicate
        if (setorService.existsByNome(nome)) {
            return ResponseEntity.status(409)
                    .body(new SetorResultDTO(false, "Setor com esse nome já existe"));
        }

        Setor setor = new Setor();
        setor.setNome(nome);
        try {
            setorService.createSetorEntity(setor);
            return ResponseEntity.ok(new SetorResultDTO(true, "Setor criado com sucesso"));
        } catch (Exception ex) {
            return ResponseEntity.status(500)
                    .body(new SetorResultDTO(false, "Erro ao salvar setor: " + ex.getMessage()));
        }
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public org.springframework.http.ResponseEntity<?> listSetores(@ModelAttribute ListSetoresRequestDTO req) {
        Integer page = req.getPage();
        Integer size = req.getSize();
        String nome = req.getNome();

        if (page == null && size == null) {
            // return full list (nome is optional)
            List<Setor> all = setorService.listAllFiltered(nome);
            List<SetorResponseDTO> dto = all.stream()
                    .map(s -> new SetorResponseDTO(s.getId(), s.getNome()))
                    .collect(Collectors.toList());
            return org.springframework.http.ResponseEntity.ok(dto);
        }

        int p = page == null ? 0 : page;
        int s = size == null ? 10 : size;
        Page<Setor> pg = setorService.listSetores(nome, p, s);
        Page<SetorResponseDTO> dtoPage = pg.map(sx -> new SetorResponseDTO(sx.getId(), sx.getNome()));
        return org.springframework.http.ResponseEntity.ok(dtoPage);
    }

    @DeleteMapping("/{id}")
    public void deleteSetor(@PathVariable Long id) {
        setorService.deleteSetor(id);
    }
}
