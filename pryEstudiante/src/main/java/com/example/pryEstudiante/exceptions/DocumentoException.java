package com.example.pryEstudiante.exceptions;

import org.springframework.http.HttpStatusCode;

public class DocumentoException extends RuntimeException{
    private HttpStatusCode code;

    public DocumentoException(String message, HttpStatusCode code){
        super(message);
        this.code = code;
    }
    public DocumentoException(String message){
        super(message);
    }
    public HttpStatusCode getCode(){return code;}
}
