package com.example.pryEstudiante.dtos;

import java.util.List;

public class AdministradorDTO {
    private Long id;
    private String nombre;
    private String usuarioAdmin;
    private String contrasenaAdmin;
    private List<CohorteDTO> cohortes;

    public AdministradorDTO() {
    }

    public AdministradorDTO(Long id, String nombre, String usuarioAdmin, String contrasenaAdmin, List<CohorteDTO> cohortes) {
        this.id = id;
        this.nombre = nombre;
        this.usuarioAdmin = usuarioAdmin;
        this.contrasenaAdmin = contrasenaAdmin;
        this.cohortes = cohortes;
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

    public String getUsuarioAdmin() {
        return usuarioAdmin;
    }

    public void setUsuarioAdmin(String usuarioAdmin) {
        this.usuarioAdmin = usuarioAdmin;
    }

    public String getContrasenaAdmin() {
        return contrasenaAdmin;
    }

    public void setContrasenaAdmin(String contrasenaAdmin) {
        this.contrasenaAdmin = contrasenaAdmin;
    }

    public List<CohorteDTO> getCohortes() {
        return cohortes;
    }

    public void setCohortes(List<CohorteDTO> cohortes) {
        this.cohortes = cohortes;
    }
}
