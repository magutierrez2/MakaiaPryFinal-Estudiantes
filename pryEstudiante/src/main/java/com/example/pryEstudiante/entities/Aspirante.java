package com.example.pryEstudiante.entities;

import jakarta.persistence.*;

import java.util.List;

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

    @OneToMany(mappedBy = "aspirante", cascade = CascadeType.ALL)
    private List<Documento> documentosRecibidos;

    @ManyToOne
    @JoinColumn(name = "administrador_id")
    private Administrador administradorEnvio;

    public Aspirante() {
    }

    public Aspirante(Long id, String nombre, String apellido, String correo, String direccion, String telefono, List<Documento> documentosRecibidos, Administrador administradorEnvio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.documentosRecibidos = documentosRecibidos;
        this.administradorEnvio = administradorEnvio;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public List<Documento> getDocumentosRecibidos() {
        return documentosRecibidos;
    }

    public Administrador getAdministradorEnvio() {
        return administradorEnvio;
    }
}
