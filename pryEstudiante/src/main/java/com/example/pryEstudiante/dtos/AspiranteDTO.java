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

    private List<DocumentoDTO> documentos;
    private AdministradorDTO administradorEnvio;

    public AspiranteDTO() {
    }

    public AspiranteDTO( String nombre, String apellido, String correo, String direccion, String telefono,List<DocumentoDTO> documentos, AdministradorDTO administradorEnvio) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.documentos = documentos;
        this.administradorEnvio = administradorEnvio;
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

    public List<DocumentoDTO> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<DocumentoDTO> documentos) {
        this.documentos = documentos;
    }

    public AdministradorDTO getAdministradorEnvio() {
        return administradorEnvio;
    }

    public void setAdministradorEnvio(AdministradorDTO administradorEnvio) {
        this.administradorEnvio = administradorEnvio;
    }
}






