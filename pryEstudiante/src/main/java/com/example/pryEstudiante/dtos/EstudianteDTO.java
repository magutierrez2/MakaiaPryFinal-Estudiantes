package com.example.pryEstudiante.dtos;

public class EstudianteDTO {
    private Long estudiante_id;
    private String usuario_estudiante;
    private String contrasena_estudiante;
    private CohorteDTO objCohorte;
    private AspiranteDTO objAspirante;

    public EstudianteDTO() {
    }

    public EstudianteDTO(String usuario_estudiante, String contrasena_estudiante) {
        this.usuario_estudiante = usuario_estudiante;
        this.contrasena_estudiante = contrasena_estudiante;
    }

    public EstudianteDTO(String usuario_estudiante, String contrasena_estudiante, CohorteDTO objCohorte, AspiranteDTO objAspirante) {
        this.usuario_estudiante = usuario_estudiante;
        this.contrasena_estudiante = contrasena_estudiante;
        this.objCohorte = objCohorte;
        this.objAspirante = objAspirante;
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

    public CohorteDTO getObjCohorte() {
        return objCohorte;
    }

    public AspiranteDTO getObjAspirante() {
        return objAspirante;
    }

    public void setObjAspirante(AspiranteDTO objAspirante) {
        this.objAspirante = objAspirante;
    }

    public void setObjCohorte(CohorteDTO objCohorte) {
        this.objCohorte = objCohorte;
    }
}
