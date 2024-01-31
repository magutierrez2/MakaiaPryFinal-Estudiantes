package com.example.pryEstudiante.exceptions;

import org.springframework.http.HttpStatusCode;

public class CohorteException extends RuntimeException{
    private HttpStatusCode code;

    public CohorteException(String message, HttpStatusCode code){
        super();
        this.code = code;
    }
    public CohorteException(String message){
        super(message);
    }
    public HttpStatusCode getCode(){return code;}
}

