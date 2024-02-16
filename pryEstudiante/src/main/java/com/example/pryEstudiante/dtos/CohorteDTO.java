package com.example.pryEstudiante.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CohorteDTO {
    private Long id_cohorte;
    private String nombre;
    private Date fecha_inicio;
    private List<EstudianteDTO> listEstudiante = new ArrayList<>();

    public CohorteDTO() {
    }

    public CohorteDTO(String nombre, Date fecha_inicio) {
        this.nombre = nombre;
        this.fecha_inicio = fecha_inicio;
    }

    public Long getId_cohorte() {
        return id_cohorte;
    }

    public void setId_cohorte(Long id_cohorte) {
        this.id_cohorte = id_cohorte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public List<EstudianteDTO> getListEstudiante() {
        return listEstudiante;
    }

    public void setListEstudiante(List<EstudianteDTO> listEstudiante) {
        this.listEstudiante = listEstudiante;
    }
}
