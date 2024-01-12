package com.example.pryEstudiante.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Cohorte")
public class Cohorte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String nombre;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_inicio")
    private Date fechaInicio;
}
