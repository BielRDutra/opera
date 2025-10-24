package com.operalatam.api.model;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;




@Entity
@Table(name = "briefings")
public class Briefing implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ramal_id", nullable = false)
    private Long ramalId;

    @Column(name = "briefings_id", nullable = false)
    private Long briefingsId;

    @Column(name = "aeronave_id", nullable = false)
    private Long aeronaveId;

    @ManyToOne
    @JoinColumn(name = "aeronave_id", insertable = false, updatable = false)
    private Aeronave aeronave;

    @Column(name = "portao_id", nullable = false)
    private Long portaoId;

    @Column(name = "box_id", nullable = false)
    private Long boxId;

    @Column(name = "servico_id", nullable = false)
    private Long servicoId;

    @Column(name = "comissaria")
    private Boolean comissaria;

    @Column(name = "tempo_solo")
    private Integer tempoSolo;

    @Column(name = "std")
    private Integer std;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRamalId() {
        return ramalId;
    }

    public void setRamalId(Long ramalId) {
        this.ramalId = ramalId;
    }

    public Long getBriefingsId() {
        return briefingsId;
    }

    public void setBriefingsId(Long briefingsId) {
        this.briefingsId = briefingsId;
    }

    public Long getAeronaveId() {
        return aeronaveId;
    }

    public void setAeronaveId(Long aeronaveId) {
        this.aeronaveId = aeronaveId;
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    public Long getPortaoId() {
        return portaoId;
    }

    public void setPortaoId(Long portaoId) {
        this.portaoId = portaoId;
    }

    public Long getBoxId() {
        return boxId;
    }

    public void setBoxId(Long boxId) {
        this.boxId = boxId;
    }

    public Long getServicoId() {
        return servicoId;
    }

    public void setServicoId(Long servicoId) {
        this.servicoId = servicoId;
    }

    public Boolean getComissaria() {
        return comissaria;
    }

    public void setComissaria(Boolean comissaria) {
        this.comissaria = comissaria;
    }

    public Integer getTempoSolo() {
        return tempoSolo;
    }

    public void setTempoSolo(Integer tempoSolo) {
        this.tempoSolo = tempoSolo;
    }

    public Integer getStd() {
        return std;
    }

    public void setStd(Integer std) {
        this.std = std;
    }
}
