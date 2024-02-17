package com.example.pryEstudiante.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Administrador")

public class Administrador {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
    @Column(length = 50)
    private String nombre;


    @Column(length = 50, unique = true)
    private String usuarioAdmin;

    @Column(length = 50)
    private String contrasenaAdmin;

    @OneToMany(mappedBy = "administrador")
    List<Documento> documentos;


    public Administrador() {
    }


    public Administrador(String contrasenaAdmin,String nombre, String usuarioAdmin) {
        this.contrasenaAdmin = contrasenaAdmin;
        this.nombre = nombre;
        this.usuarioAdmin = usuarioAdmin;


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



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContrasenaAdmin(String contrasenaAdmin) {
        this.contrasenaAdmin = contrasenaAdmin;
    }
}



