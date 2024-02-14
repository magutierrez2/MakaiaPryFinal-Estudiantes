package com.example.pryEstudiante.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "aspirante")
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
    @OneToOne (optional = false)
    Estudiante estudiante;




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

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Documento> getDocumentosRecibidos() {
        return documentosRecibidos;
    }

    public void setDocumentosRecibidos(List<Documento> documentosRecibidos) {
        this.documentosRecibidos = documentosRecibidos;
    }


}
