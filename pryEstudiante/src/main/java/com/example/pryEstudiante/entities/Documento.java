package com.example.pryEstudiante.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Documento")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String cedula;

    @Column(length = 50)
    private String acta;

    @Column(length = 50)
    private Boolean estado;
    @Column(length = 50)
    private String nombre_aspirante;

    @ManyToOne(optional = false)
    Aspirante aspirante;
    @ManyToOne(optional =false)
    Administrador administrador;

    public Documento() {
    }
    public Documento(String cedula, String acta, Boolean estado, String nombre_aspirante, Aspirante aspirante_id, Administrador administradot_id) {
        this.cedula = cedula;
        this.acta = acta;
        this.estado = estado;
        this.nombre_aspirante = nombre_aspirante;
        this.aspirante = aspirante_id;
        this.administrador = administradot_id;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getActa() {
        return acta;
    }

    public void setActa(String acta) {
        this.acta = acta;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getNombre_aspirante() {
        return nombre_aspirante;
    }

    public void setNombre_aspirante(String nombre_aspirante) {
        this.nombre_aspirante = nombre_aspirante;
    }

    public Aspirante getAspirante() {
        return aspirante;
    }

    public void setAspirante(Aspirante aspirante) {
        this.aspirante = aspirante;
    }

    public Administrador getAdministrador() {
        return administrador;
    }
}
