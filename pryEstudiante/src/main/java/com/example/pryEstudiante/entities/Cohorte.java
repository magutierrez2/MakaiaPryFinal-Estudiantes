package com.example.pryEstudiante.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

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
    @ManyToOne
    @JoinColumn(name = "administrador_id")
    private Administrador administrador;

    @OneToMany(mappedBy = "cohorte", cascade = CascadeType.ALL)
    private List<Estudiante> estudiantes;
    public Cohorte() {
    }

    public Cohorte(Long id, String nombre, Date fechaInicio, Administrador administrador, List<Estudiante> estudiantes) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.administrador = administrador;
        this.estudiantes = estudiantes;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
}
