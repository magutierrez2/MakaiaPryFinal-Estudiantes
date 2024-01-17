package com.example.pryEstudiante.dtos;

import java.util.Date;
import java.util.List;

public class CohorteDTO {
    private Long id;
    private String nombre;
    private Date fechaInicio;
    private AdministradorDTO administrador;
    private List<EstudianteDTO> estudiantes;

    public CohorteDTO() {
    }

    public CohorteDTO(Long id, String nombre, Date fechaInicio, AdministradorDTO administrador, List<EstudianteDTO> estudiantes) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.administrador = administrador;
        this.estudiantes = estudiantes;
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public AdministradorDTO getAdministrador() {
        return administrador;
    }

    public void setAdministrador(AdministradorDTO administrador) {
        this.administrador = administrador;
    }

    public List<EstudianteDTO> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<EstudianteDTO> estudiantes) {
        this.estudiantes = estudiantes;
    }
}
