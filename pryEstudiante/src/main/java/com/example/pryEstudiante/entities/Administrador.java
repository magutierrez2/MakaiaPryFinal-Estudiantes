package com.example.pryEstudiante.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Administrador")
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_admin;
    @Column(length = 50)
    private String nombre;
    @Column(length = 50, unique = true)
    private String usuario_admin;
    @Column(length = 50)
    private String contrasena_admin;

    public Administrador() {
    }

    public Administrador(String nombre, String usuario_admin, String contrasena_admin) {
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
