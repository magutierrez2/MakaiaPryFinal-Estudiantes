package com.example.pryEstudiante.controllers;

import com.example.pryEstudiante.dtos.CohorteDTO;
import com.example.pryEstudiante.entities.Cohorte;
import com.example.pryEstudiante.services.CohorteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cohorte")
public class CohorteController {
    @Autowired
    private CohorteService cohorteService;

    @PostMapping
    public Cohorte crearCohorte(@RequestBody CohorteDTO dto){
        return this.cohorteService.crearCohorte(dto);
    }
    @GetMapping
    public List<Cohorte> listarCohorte(){
        return this.cohorteService.listarCohorte();
    }
}
