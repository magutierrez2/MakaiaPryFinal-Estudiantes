package com.example.pryEstudiante.entities;

import com.example.pryEstudiante.dtos.EstadoDocumento;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "Documento")
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doc_id;
    @Column(length = 50)
    private String nombre_documento;
    @Column(length = 255)
    private String contenido_documento;
    @Column()
    @Enumerated(EnumType.STRING)
    private EstadoDocumento estado;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "aspi_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Aspirante aspirante;

    public Documento() {
    }

    public Documento(String nombre_documento, String contenido_documento, EstadoDocumento estado) {
        this.nombre_documento = nombre_documento;
        this.contenido_documento = contenido_documento;
        this.estado = estado;
    }

    public Documento(String nombre_documento, String contenido_documento, EstadoDocumento estado, Aspirante aspirante) {
        this.nombre_documento = nombre_documento;
        this.contenido_documento = contenido_documento;
        this.estado = estado;
        this.aspirante = aspirante;
    }

    public Long getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(Long doc_id) {
        this.doc_id = doc_id;
    }

    public String getNombre_documento() {
        return nombre_documento;
    }

    public void setNombre_documento(String nombre_documento) {
        this.nombre_documento = nombre_documento;
    }

    public String getContenido_documento() {
        return contenido_documento;
    }

    public void setContenido_documento(String contenido_documento) {
        this.contenido_documento = contenido_documento;
    }

    public EstadoDocumento getEstado() {
        return estado;
    }

    public void setEstado(EstadoDocumento estado) {
        this.estado = estado;
    }

    public Aspirante getAspirante() {
        return aspirante;
    }

    public void setAspirante(Aspirante aspirante) {
        this.aspirante = aspirante;
    }
}
