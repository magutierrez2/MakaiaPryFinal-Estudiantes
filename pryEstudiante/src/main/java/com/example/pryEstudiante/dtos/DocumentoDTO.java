package com.example.pryEstudiante.dtos;

import java.util.Date;

public class DocumentoDTO {
    private Long id;
    private String cedula;

    private String acta;
    private Boolean estado;
    private String nombre_aspirante;
    private Long aspirante_id;
    private Long administrador_id;

    public DocumentoDTO() {
    }

    public DocumentoDTO(String cedula, String acta, Boolean estado, String nombre_aspirante, Long aspirante_id, Long administrador_id) {
        this.cedula = cedula;
        this.acta = acta;
        this.estado = estado;
        this.nombre_aspirante = nombre_aspirante;
        this.aspirante_id = aspirante_id;
        this.administrador_id = administrador_id;
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

    public Long getAspirante_id() {
        return aspirante_id;
    }

    public void setAspirante_id(Long aspirante_id) {
        this.aspirante_id = aspirante_id;
    }

    public Long getAdministrador_id() {
        return administrador_id;
    }

    public void setAdministrador_id(Long administrador_id) {
        this.administrador_id = administrador_id;
    }
}
