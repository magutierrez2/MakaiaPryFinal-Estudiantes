package com.example.pryEstudiante.entities;

import jakarta.persistence.*;

import java.util.Date;

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


    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private Date fechaActualizacion;
    @ManyToOne(optional = false)
    Aspirante aspirante_id;
    @ManyToOne(optional =false)
    Administrador administrador;

    public Documento(String nombre, String tipoContenido, Date fechaCreacion, Date fechaActualizacion, Date actualizacion, Aspirante aspiranteExiste) {
    }
    public Documento(String nombre, String tipoContenido, Date fechaCreacion, Date fechaActualizacion, Aspirante aspirante_id) {
        this.nombre = nombre;
        this.tipoContenido = tipoContenido;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.aspirante_id=aspirante_id;
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


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoContenido(String tipoContenido) {
        this.tipoContenido = tipoContenido;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Aspirante getAspirante_id() {
        return aspirante_id;
    }

    public void setAspirante_id(Aspirante aspirante_id) {
        this.aspirante_id = aspirante_id;
    }
}
