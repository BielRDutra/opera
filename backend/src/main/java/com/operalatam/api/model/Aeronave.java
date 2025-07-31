package com.operalatam.api.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "aeronaves")
public class Aeronave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "matricula_id", nullable = false)
    private Long matriculaId;

    @Column(name = "configuracao_id", nullable = false)
    private Long configuracaoId;

    @Column(name = "nome", length = 20)
    private String nome;

    @OneToMany(mappedBy = "aeronave")
    private Set<Briefing> briefings;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMatriculaId() {
        return matriculaId;
    }

    public void setMatriculaId(Long matriculaId) {
        this.matriculaId = matriculaId;
    }

    public Long getConfiguracaoId() {
        return configuracaoId;
    }

    public void setConfiguracaoId(Long configuracaoId) {
        this.configuracaoId = configuracaoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Briefing> getBriefings() {
        return briefings;
    }

    public void setBriefings(Set<Briefing> briefings) {
        this.briefings = briefings;
    }
}
