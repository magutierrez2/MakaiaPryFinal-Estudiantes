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
}
