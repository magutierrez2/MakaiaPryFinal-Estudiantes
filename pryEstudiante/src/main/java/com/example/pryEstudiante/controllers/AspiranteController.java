package com.example.pryEstudiante.controllers;

import com.example.pryEstudiante.dtos.AspiranteDTO;
import com.example.pryEstudiante.entities.Aspirante;
import com.example.pryEstudiante.services.AspiranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/aspirante")

public class AspiranteController {
    @Autowired
    private AspiranteService aspiranteService;
    @GetMapping
    public ArrayList<Aspirante> getAspirantes(){
        return this.aspiranteService.getAspirantes();
    }
@PostMapping
    public Aspirante crearAsp(@RequestBody AspiranteDTO aspirante){
        return this.aspiranteService.crearAspirante(aspirante);
}


}
