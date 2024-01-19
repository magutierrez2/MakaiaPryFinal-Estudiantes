package com.example.pryEstudiante.exceptions;

import org.springframework.http.HttpStatusCode;

public class AdministradorException extends RuntimeException{
    private HttpStatusCode code;

    public AdministradorException(String message, HttpStatusCode code){
        super(message);
        this.code = code;
    }
    public AdministradorException(String message){
        super(message);
    }
    public HttpStatusCode getCode(){return code;}
}
