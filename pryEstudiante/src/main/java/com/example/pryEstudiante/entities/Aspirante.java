package com.example.pryEstudiante.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Aspirante")
public class Aspirante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aspi_id;
    @Column(length = 50, unique = true)
    private String cedula;
    @Column(length = 50)
    private String nombre;

    @Column(length = 50)
    private String apellido;

    @Column(length = 100)
    private String correo;
    @Column(length = 100)
    private String direccion;
    @Column(length = 20)
    private String telefono;
    @OneToMany(mappedBy = "aspirante", cascade = CascadeType.ALL)
    private List<Documento> documentos = new ArrayList<>();


    public Aspirante() {
    }

    public Aspirante(String cedula, String nombre, String apellido, String correo, String direccion, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Long getAspi_id() {
        return aspi_id;
    }

    public void setAspi_id(Long aspi_id) {
        this.aspi_id = aspi_id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
        for (Documento documento: documentos){
            documento.setAspirante(this);
        }
    }


}
