package com.example.pryEstudiante.dtos;

import java.util.Date;

public class DocumentoDTO {
    private Long id;
    private String nombre;
    private String tipoContenido;
    private Date fechaCreacion;
    private Date fechaActualizacion;

    public DocumentoDTO() {
    }

    public DocumentoDTO(Long id, String nombre, String tipoContenido, Date fechaCreacion, Date fechaActualizacion) {
        this.id = id;
        this.nombre = nombre;
        this.tipoContenido = tipoContenido;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoContenido() {
        return tipoContenido;
    }

    public void setTipoContenido(String tipoContenido) {
        this.tipoContenido = tipoContenido;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
