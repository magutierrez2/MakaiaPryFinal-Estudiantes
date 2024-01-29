package com.example.pryEstudiante.entities;

import jakarta.persistence.*;

import java.util.Date;
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

    public Cohorte(String nombre, Date fechaInicio, Administrador administrador, Estudiante estudiante) {
        this.estudiantes = estudiantes;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.administrador = administrador;

    }

    public Cohorte(String nombre, Date fechaInicio, Estudiante estudiante) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
}
