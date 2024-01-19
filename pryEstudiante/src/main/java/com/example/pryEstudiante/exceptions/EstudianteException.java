package com.example.pryEstudiante.exceptions;

import org.springframework.http.HttpStatusCode;

public class EstudianteException extends RuntimeException{
    private HttpStatusCode code;

    public EstudianteException(String message, HttpStatusCode code){
        super(message);
        this.code = code;
    }
    public EstudianteException(String message){
        super(message);
    }
    public HttpStatusCode getCode(){return code;}
}
