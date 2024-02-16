package com.example.pryEstudiante.controllers;

import com.example.pryEstudiante.dtos.DocumentoDTO;
import com.example.pryEstudiante.entities.Documento;
import com.example.pryEstudiante.services.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/documento")
public class DocumentoController {
    @Autowired
    DocumentoService docService;

    @PostMapping
    public Documento crearDoc(@RequestBody DocumentoDTO dto){
        return this.docService.crearDocumento(dto);
    }
    @GetMapping
    public List<Documento> listarDoc(){
        return this.docService.listarDocumento();
    }
}
