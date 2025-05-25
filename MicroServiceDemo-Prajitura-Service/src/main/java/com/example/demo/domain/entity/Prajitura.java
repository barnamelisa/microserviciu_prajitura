package com.example.demo.domain.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "prajitura")
public class Prajitura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prajitura_id")
    private Long id;

    @Column(name = "nume_prajitura")
    private String name;

    @Column(name = "descriere")
    private String descriere;

    @Column(name = "cofetarie_id")
    private int idCofetarie;

    @Column(name = "pret")
    private BigDecimal pret;

    @Column(name = "data_productie")
    private LocalDate dataProductie;

    @Column(name = "data_expirare")
    private LocalDate dataExpirare;

    @Column(name = "imagine")
    private String imagine;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public BigDecimal getPret() {
        return pret;
    }

    public void setPret(BigDecimal pret) {
        this.pret = pret;
    }

    public Integer getCofetarieId() {
        return idCofetarie;
    }

    public void setCofetarieId(Integer cofetarieId) {
        this.idCofetarie = cofetarieId;
    }

    public LocalDate getDataExpirare() {
        return dataExpirare;
    }

    public void setDataExpirare(LocalDate dataExpirare) {
        this.dataExpirare = dataExpirare;
    }

    public LocalDate getDataProductie() {
        return dataProductie;
    }

    public void setDataProductie(LocalDate dataProductie) {
        this.dataProductie = dataProductie;
    }

    public String getImagine() {
        return imagine;
    }

    public void setImagine(String imagine) {
        this.imagine = imagine;
    }
}