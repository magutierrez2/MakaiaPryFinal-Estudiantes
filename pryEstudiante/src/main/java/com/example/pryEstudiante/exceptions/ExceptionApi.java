package com.example.pryEstudiante.exceptions;

import org.springframework.http.HttpStatusCode;

public class ExceptionApi extends RuntimeException{
    private HttpStatusCode code;
    public ExceptionApi(String message){
        super(message);
    }
    public ExceptionApi(String message, Throwable cause){
        super(message, cause);
    }
    public  ExceptionApi(String message, Throwable cause, HttpStatusCode code){
        super(message, cause);
        this.code = code;
    }
    public ExceptionApi(String message, HttpStatusCode code){
        super(message);
        this.code= code;
    }

    public HttpStatusCode getCode() {
        return code;
    }
}
