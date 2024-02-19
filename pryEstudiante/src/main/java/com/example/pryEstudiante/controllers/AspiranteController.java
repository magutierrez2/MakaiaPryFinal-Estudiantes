package com.example.pryEstudiante.controllers;
import com.example.pryEstudiante.dtos.AspiranteDTO;
import com.example.pryEstudiante.entities.Aspirante;
import com.example.pryEstudiante.services.AspiranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/aspirante")
public class AspiranteController {
    @Autowired
    AspiranteService aspiranteService;

    @PostMapping
    public Aspirante crearAspi(@RequestBody AspiranteDTO dto){
        return aspiranteService.crearAspirante(dto);
    }
    @GetMapping
    public List<Aspirante> listarAspi(){
        return this.aspiranteService.listarAspirante();
    }
}
