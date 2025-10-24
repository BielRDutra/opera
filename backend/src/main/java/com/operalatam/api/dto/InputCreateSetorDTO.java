package com.operalatam.api.dto;

import java.io.Serializable;

/**
 * DTO de entrada para criação/atualização de Setor.
 * Contém apenas os campos recebidos via API (sem id).
 */
public class InputCreateSetorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;

    public InputCreateSetorDTO() {
    }

    public InputCreateSetorDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
