package com.example.pryEstudiante.exceptions;

import com.example.pryEstudiante.dtos.ResponseError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionsHandler {
    @ExceptionHandler(value = {ExceptionApi.class})
    public ResponseEntity<ResponseError> handleRegistroApiException(ExceptionApi reg){
        ResponseError res = new ResponseError(reg.getMessage(), reg.getCode().value());
        return new ResponseEntity<ResponseError>(res, reg.getCode());
    }
}
