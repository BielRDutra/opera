package com.operalatam.api.dto;

public class InputCreateSetorDTO {
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
