package com.example.pryEstudiante.dtos;

import com.example.pryEstudiante.entities.Documento;

import java.util.ArrayList;
import java.util.List;

public class AspiranteDTO {

    private Long aspi_id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String direccion;
    private String telefono;
    private List<DocumentoDTO> listDocumento = new ArrayList<>();

    public AspiranteDTO() {
    }

    public AspiranteDTO(String cedula,String nombre, String apellido, String correo, String direccion, String telefono) {
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

    public List<DocumentoDTO> getListDocumento() {
        return listDocumento;
    }

    public void setListDocumento(List<DocumentoDTO> listDocumento) {
        this.listDocumento = listDocumento;
    }

}
