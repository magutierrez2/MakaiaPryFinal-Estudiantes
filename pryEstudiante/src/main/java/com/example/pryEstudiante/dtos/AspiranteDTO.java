package com.example.pryEstudiante.dtos;

import java.util.Date;
import java.util.List;

public class AspiranteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String direccion;
    private String telefono;
    private Date fechaInscripcion;
    private List<DocumentoDTO> documentosRecibidos;
    private AdministradorDTO administradorEnvio;

    public AspiranteDTO() {
    }

    public AspiranteDTO(Long id, String nombre, String apellido, String correo, String direccion, String telefono, Date fechaInscripcion,List<DocumentoDTO> documentosRecibidos, AdministradorDTO administradorEnvio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaInscripcion = fechaInscripcion;
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

    public List<DocumentoDTO> getDocumentosRecibidos() {
        return documentosRecibidos;
    }

    public AdministradorDTO getAdministradorEnvio() {
        return administradorEnvio;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDocumentosRecibidos(List<DocumentoDTO> documentosRecibidos) {
        this.documentosRecibidos = documentosRecibidos;
    }

    public void setAdministradorEnvio(AdministradorDTO administradorEnvio) {
        this.administradorEnvio = administradorEnvio;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
}
