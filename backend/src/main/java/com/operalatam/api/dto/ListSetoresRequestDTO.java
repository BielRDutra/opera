package com.operalatam.api.dto;

public class ListSetoresRequestDTO {
    private Integer page;
    private Integer size;
    private String nome;

    public ListSetoresRequestDTO() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
