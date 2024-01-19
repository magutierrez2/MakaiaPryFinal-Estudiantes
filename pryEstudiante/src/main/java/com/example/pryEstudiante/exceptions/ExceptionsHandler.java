package com.example.pryEstudiante.exceptions;

import com.example.pryEstudiante.dtos.ResponseErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(value = {DocumentoException.class})
    public ResponseEntity<ResponseErrorDTO> handleDocumentoException(DocumentoException e) {
        ResponseErrorDTO res = new ResponseErrorDTO(e.getMessage(), e.getCode().value());
        return new ResponseEntity<ResponseErrorDTO>(res, e.getCode());
    }

    public ResponseEntity<ResponseErrorDTO> handleEstudianteException(EstudianteException e) {
        ResponseErrorDTO res = new ResponseErrorDTO(e.getMessage(), e.getCode().value());
        return new ResponseEntity<ResponseErrorDTO>(res, e.getCode());
    }
}
