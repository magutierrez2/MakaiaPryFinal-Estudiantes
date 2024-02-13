package com.example.pryEstudiante.controllers;

import com.example.pryEstudiante.entities.Aspirante;
import com.example.pryEstudiante.services.AspiranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/aspirante")

public class AspiranteController {
    @Autowired
    private AspiranteService aspiranteService;
    @GetMapping
    public ArrayList<Aspirante> getAspirantes(){
        return this.aspiranteService.getAspirantes();
    }
@PostMapping
    public Aspirante saveAspirante(@RequestBody Aspirante aspirante){
        return this.aspiranteService.saveAspirante(aspirante);
}
}
