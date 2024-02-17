package com.example.pryEstudiante.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "Estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long estudiante_id;

    @Column(length = 100, unique = true)
    private String usuario_estudiante;

    @Column(length = 100)
    private String contrasena_estudiante;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cohorte")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Cohorte cohorte;

    @OneToOne()
    @JoinColumn(name = "aspi_id")
    private Aspirante aspirante;


    public Estudiante() {
    }

    public Estudiante(String usuario_estudiante, String contrasena_estudiante) {
        this.usuario_estudiante = usuario_estudiante;
        this.contrasena_estudiante = contrasena_estudiante;
    }

    public Estudiante(String usuario_estudiante, String contrasena_estudiante, Cohorte cohorte, Aspirante aspirante) {
        this.usuario_estudiante = usuario_estudiante;
        this.contrasena_estudiante = contrasena_estudiante;
        this.cohorte = cohorte;
        this.aspirante = aspirante;
    }

    public Long getEstudiante_id() {
        return estudiante_id;
    }

    public void setEstudiante_id(Long estudiante_id) {
        this.estudiante_id = estudiante_id;
    }

    public String getUsuario_estudiante() {
        return usuario_estudiante;
    }

    public void setUsuario_estudiante(String usuario_estudiante) {
        this.usuario_estudiante = usuario_estudiante;
    }

    public String getContrasena_estudiante() {
        return contrasena_estudiante;
    }

    public void setContrasena_estudiante(String contrasena_estudiante) {
        this.contrasena_estudiante = contrasena_estudiante;
    }

    public Cohorte getCohorte() {
        return cohorte;
    }

    public void setCohorte(Cohorte cohorte) {
        this.cohorte = cohorte;
    }

    public Aspirante getAspirante() {
        return aspirante;
    }

    public void setAspirante(Aspirante aspirante) {
        this.aspirante = aspirante;
    }

}
