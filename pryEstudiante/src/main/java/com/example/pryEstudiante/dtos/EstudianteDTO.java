package com.example.pryEstudiante.dtos;

public class EstudianteDTO {
    private Long id;
    private String nombre;
    private String usuario;
    private String contrasena;
    private CohorteDTO cohorte;

    public EstudianteDTO() {
    }

    public EstudianteDTO(Long id, String nombre, String usuario, String contrasena, CohorteDTO cohorte) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.cohorte = cohorte;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public CohorteDTO getCohorte() {
        return cohorte;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setCohorte(CohorteDTO cohorte) {
        this.cohorte = cohorte;
    }
}
