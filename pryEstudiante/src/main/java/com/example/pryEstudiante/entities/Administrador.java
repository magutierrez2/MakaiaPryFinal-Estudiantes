package com.example.pryEstudiante.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Administrador")
public class Administrador {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

    @Column(length = 50)
    private String nombre;


    @Column(length = 50, unique = true)
    private String usuarioAdmin;

    @Column(length = 50)
    private String contrasenaAdmin;

    public Administrador() {
    }

    public Administrador(String nombre, String usuarioAdmin, String contrasenaAdmin) {

        this.nombre = nombre;
        this.usuarioAdmin = usuarioAdmin;
        this.contrasenaAdmin = contrasenaAdmin;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuarioAdmin() {
        return usuarioAdmin;
    }

    public String getContrasenaAdmin() {
        return contrasenaAdmin;
    }


}
