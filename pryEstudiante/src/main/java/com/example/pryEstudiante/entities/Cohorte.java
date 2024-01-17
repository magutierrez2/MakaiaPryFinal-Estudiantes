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
    @OneToMany(mappedBy = "cohorte", cascade = CascadeType.ALL)
    private List<Estudiante> estudiantes;

    public Cohorte() {
    }

    public Cohorte(String nombre, Date fechaInicio, List<Estudiante> estudiantes) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
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

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    @ManyToOne
    @JoinColumn(name = "administrador_id")
    private Administrador administrador;

    public Cohorte(Administrador administrador) {
        this.administrador = administrador;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
}
