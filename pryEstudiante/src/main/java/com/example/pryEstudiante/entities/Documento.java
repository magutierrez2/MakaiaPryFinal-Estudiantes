package com.example.pryEstudiante.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Documento")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String nombre;

    @Column(length = 50)
    private String tipoContenido;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_actualizacion")
    private Date fechaActualizacion;
    @ManyToOne
    @JoinColumn(name = "aspirante_id")
    private Aspirante aspirante;

    public Documento() {
    }

    public Documento(Long id, String nombre, String tipoContenido, Date fechaCreacion, Date fechaActualizacion, Aspirante aspirante) {
        this.id = id;
        this.nombre = nombre;
        this.tipoContenido = tipoContenido;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.aspirante = aspirante;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoContenido() {
        return tipoContenido;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public Aspirante getAspirante() {
        return aspirante;
    }
}
