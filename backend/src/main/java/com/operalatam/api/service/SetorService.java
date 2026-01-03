package com.operalatam.api.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.operalatam.api.model.Setor;
import com.operalatam.api.repository.SetorRepository;

@Service
public class SetorService {

    private final SetorRepository setorRepository;

    public SetorService(SetorRepository setorRepository) {
        this.setorRepository = setorRepository;
    }

    public Page<Setor> listSetores(String nomeFilter, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        if (nomeFilter == null || nomeFilter.isBlank()) {
            return setorRepository.findAll(pageable);
        }
        return setorRepository.findByNomeContainingIgnoreCase(nomeFilter, pageable);
    }

    public String getSetor(String nome) {
        return setorRepository.findByNome(nome).map(Setor::getNome).orElse(null);
    }

    public boolean existsByNome(String nome) {
        return setorRepository.findByNome(nome).isPresent();
    }

    public Setor createSetorEntity(Setor setor) {
        return setorRepository.save(setor);
    }

    public String deleteSetor(Long id) {
        setorRepository.deleteById(id);
        return "Setor deletado";
    }

    public Setor createSetor(String nome) {
        Setor s = new Setor();
        s.setNome(nome);
        return setorRepository.save(s);
    }

    public List<Setor> listAll() {
        return setorRepository.findAll();
    }

    public List<Setor> listAllFiltered(String nomeFilter) {
        if (nomeFilter == null || nomeFilter.isBlank()) {
            return setorRepository.findAll();
        }
        // reuse repository method with large pageable to get all matching
        return setorRepository.findByNomeContainingIgnoreCase(nomeFilter, PageRequest.of(0, Integer.MAX_VALUE)).getContent();
    }

}
