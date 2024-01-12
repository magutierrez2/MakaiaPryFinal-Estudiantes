package com.example.pryEstudiante.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Aspirante")
public class Aspirante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String nombre;

    @Column(length = 50)
    private String apellido;

    @Column(length = 100, unique = true)
    private String correo;

    @Column(length = 100)
    private String direccion;

    @Column(length = 15)
    private String telefono;
    @ManyToOne
    @JoinColumn(name = "documento_id")
    private Documento documento;
}
