package com.example.pryEstudiante.dtos;

import com.example.pryEstudiante.entities.Cohorte;
import com.example.pryEstudiante.entities.Estudiante;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CohorteDTO {
    private Long id;
    private String nombre;
    private Date fechaInicio;
    private Long administrador_id;
    private Long estudiante_id;

    public CohorteDTO() {
    }

    public CohorteDTO(Long id, String nombre, Date fechaInicio, Long administrador_id, Long estudiante_id) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.administrador_id = administrador_id;
        this.estudiante_id = estudiante_id;
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

    public Long getAdministrador_id() {
        return administrador_id;
    }

    public void setAdministrador_id(Long administrador_id) {
        this.administrador_id = administrador_id;
    }

    public Long getEstudiante_id() {
        return estudiante_id;
    }

    public void setEstudiante_id(Long estudiante_id) {
        this.estudiante_id = estudiante_id;
    }
}
