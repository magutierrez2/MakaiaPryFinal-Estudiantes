package com.example.pryEstudiante.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String nombre;

    @Column(length = 50, unique = true)
    private String usuario;

    @Column(length = 100)
    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "cohorte_id")
    private Cohorte cohorte;

    public Estudiante() {
    }

    public Estudiante(String nombre, String usuario, String contrasena, Cohorte cohorte) {
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

    public Cohorte getCohorte() {
        return cohorte;
    }
}
