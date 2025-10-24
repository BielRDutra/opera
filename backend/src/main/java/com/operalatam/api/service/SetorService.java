package com.operalatam.api.service;

import org.springframework.stereotype.Service;

import com.operalatam.api.model.Setor;
import com.operalatam.api.repository.SetorRepository;

@Service
public class SetorService {

    private final SetorRepository setorRepository;

    public SetorService(SetorRepository setorRepository) {
        this.setorRepository = setorRepository;
    }

    public Setor createSetor(Setor setor) {
        //Uma funçao pra validar 
        // Melhorar o retorno para retornar os erros 
        // Alterar o retorno de outpout para DTO seguindo as boas praticas
        if (setor.getNome() == null || setor.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome do setor não pode ser nulo ou vazio.");
        }
        return setorRepository.save(setor);

    }

    public void deleteSetor(Long id) {
        setorRepository.deleteById(id);
    }

}