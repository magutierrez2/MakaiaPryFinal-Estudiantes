package com.example.pryEstudiante.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Cohorte")
public class Cohorte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cohorte;

    @Column(length = 50)
    private String nombre;
    @Column()
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fecha_inicio;
    @OneToMany(mappedBy = "cohorte", cascade = CascadeType.ALL)
    private List<Estudiante> estudiantes = new ArrayList<>();

    public Cohorte() {
    }

    public Cohorte(String nombre, Date fecha_inicio) {
        this.nombre = nombre;
        this.fecha_inicio = fecha_inicio;
    }

    public Long getId_cohorte() {
        return id_cohorte;
    }

    public void setId_cohorte(Long id_cohorte) {
        this.id_cohorte = id_cohorte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
        for (Estudiante estudiante: estudiantes){
            estudiante.setCohorte(this);
        }
    }
}
