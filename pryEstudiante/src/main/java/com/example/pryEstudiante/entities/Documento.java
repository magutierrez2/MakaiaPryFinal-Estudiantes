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
    private String tipo;

    @Column(length = 50)
    private String contenido;

    @Column(length = 50)
    private Boolean estado;

    @ManyToOne(optional = false)
    Aspirante aspirante;
    @ManyToOne(optional =false)
    Administrador administrador;

    public Documento() {
    }
    public Documento(String tipo, String contenido, Boolean estado,Aspirante aspirante, Administrador administrador) {
        this.tipo = tipo;
        this.contenido = contenido;
        this.estado = estado;

    }

    // Getter y setter para aspirante
    public Aspirante getAspirante() {
        return aspirante;
    }

    public void setAspirante(Aspirante aspirante) {
        this.aspirante = aspirante;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
}
