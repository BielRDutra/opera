package com.operalatam.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "bagagens")
public class Bagagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long etiqueta;

    private String reserva;

    @Column(length = 20)
    private String leitura;

    @Column(name = "check_2")
    private Boolean check2;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Long etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getReserva() {
        return reserva;
    }

    public void setReserva(String reserva) {
        this.reserva = reserva;
    }

    public String getLeitura() {
        return leitura;
    }

    public void setLeitura(String leitura) {
        this.leitura = leitura;
    }

    public Boolean getCheck2() {
        return check2;
    }

    public void setCheck2(Boolean check2) {
        this.check2 = check2;
    }
}
