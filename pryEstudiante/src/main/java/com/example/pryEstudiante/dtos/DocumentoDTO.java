package com.example.pryEstudiante.dtos;

public class DocumentoDTO {
    private Long doc_id;
    private String nombre_documento;
    private String ruta_archivo;
    private EstadoDocumento estado;
    private AspiranteDTO objAspirante;

    public DocumentoDTO() {
    }

    public DocumentoDTO(String nombre_documento,String ruta_archivo, EstadoDocumento estado) {
        this.nombre_documento = nombre_documento;
        this.ruta_archivo = ruta_archivo;
        this.estado = estado;
    }

    public DocumentoDTO(String nombre_documento, String ruta_archivo, EstadoDocumento estado, AspiranteDTO objAspirante) {
        this.nombre_documento = nombre_documento;
        this.ruta_archivo = ruta_archivo;
        this.estado = estado;
        this.objAspirante = objAspirante;
    }

    public Long getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(Long doc_id) {
        this.doc_id = doc_id;
    }

    public String getNombre_documento() {
        return nombre_documento;
    }

    public void setNombre_documento(String nombre_documento) {
        this.nombre_documento = nombre_documento;
    }

    public String getruta_archivo() {
        return ruta_archivo;
    }

    public void setruta_archivo(String ruta_archivo) {
        this.ruta_archivo = ruta_archivo;
    }

    public EstadoDocumento getEstado() {
        return estado;
    }

    public void setEstado(EstadoDocumento estado) {
        this.estado = estado;
    }

    public AspiranteDTO getObjAspirante() {
        return objAspirante;
    }

    public void setObjAspirante(AspiranteDTO objAspirante) {
        this.objAspirante = objAspirante;
    }
}
