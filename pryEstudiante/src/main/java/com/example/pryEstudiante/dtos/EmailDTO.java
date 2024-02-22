package com.example.pryEstudiante.dtos;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.HashMap;

public class EmailDTO {
    private String destinatario;
    private String asunto;
    private String plantillaMensaje;
    private String rutaArchivo;
    private HashMap<String,String> infoMensaje = new HashMap<>();

    public EmailDTO(String destinatario, String asunto, String plantillaMensaje) {
        this.destinatario = destinatario;
        this.asunto = asunto;
        this.plantillaMensaje = plantillaMensaje;
    }

    public EmailDTO(String destinatario, String asunto, String plantillaMensaje, String rutaArchivo) {
        this.destinatario = destinatario;
        this.asunto = asunto;
        this.plantillaMensaje = plantillaMensaje;
        this.rutaArchivo = rutaArchivo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getPlantillaMensaje() {
        return plantillaMensaje;
    }

    public void setPlantillaMensaje(String plantillaMensaje) {
        this.plantillaMensaje = plantillaMensaje;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public HashMap<String, String> getInfoMensaje() {
        return infoMensaje;
    }

    public void setInfoMensaje(HashMap<String, String> infoMensaje) {
        this.infoMensaje = infoMensaje;
    }
}
