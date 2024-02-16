package com.example.pryEstudiante.dtos;

public class AdministradorDTO {
    private Long id_admin;
    private String nombre;
    private String usuario_admin;
    private String contrasena_admin;

    public AdministradorDTO() {
    }

    public AdministradorDTO(String nombre, String usuario_admin, String contrasena_admin) {
        this.nombre = nombre;
        this.usuario_admin = usuario_admin;
        this.contrasena_admin = contrasena_admin;
    }

    public Long getId_admin() {
        return id_admin;
    }

    public void setId_admin(Long id_admin) {
        this.id_admin = id_admin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario_admin() {
        return usuario_admin;
    }

    public void setUsuario_admin(String usuario_admin) {
        this.usuario_admin = usuario_admin;
    }

    public String getContrasena_admin() {
        return contrasena_admin;
    }

    public void setContrasena_admin(String contrasena_admin) {
        this.contrasena_admin = contrasena_admin;
    }
}
