package com.example.pryEstudiante.dtos;

import com.example.pryEstudiante.entities.Administrador;
import com.example.pryEstudiante.entities.Aspirante;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class DocumentoDTO {
    private Long id;
    private String tipo;

    private String contenido;
    private Boolean estado;
    Aspirante aspirante;

    Administrador administrador;

    public DocumentoDTO() {
    }

    public DocumentoDTO(String tipo, String contenido, Boolean estado) {
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

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
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

}
