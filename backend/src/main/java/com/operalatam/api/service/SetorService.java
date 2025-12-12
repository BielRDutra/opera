package com.operalatam.api.service;

import com.operalatam.api.model.Setor;

public class SetorService {
    public String getSetor(String nome) {
        return null;
    }

    public String createSetor(Setor setor) {
        return "Setor criado";
    }

    public String deleteSetor(Long id) {
        return "Setor deletado";
    }

    public Setor createSetor(String nome) { 
        throw new UnsupportedOperationException("Unimplemented method 'createSetor'");
    }

}
