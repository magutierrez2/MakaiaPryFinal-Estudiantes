package com.example.pryEstudiante.controllers;

import com.example.pryEstudiante.dtos.CohorteDTO;
import com.example.pryEstudiante.entities.Cohorte;
import com.example.pryEstudiante.services.CohorteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/cohorte")
public class CohorteController {
    private CohorteService cohService;


    @Autowired
    public CohorteController(CohorteService cohService){
        this.cohService = cohService;
    }

    @PostMapping()
    public CohorteDTO crear(@RequestBody CohorteDTO dto){
        return this.cohService.crear(dto);
    }
    @GetMapping()
    public List<CohorteDTO> listar(){
        return this.cohService.listar();
    }
    @GetMapping("/cohorte/{id}")
    public Optional<Cohorte> buscar(@PathVariable("id") Long id){
        return this.cohService.buscar(id);
    }
    @PutMapping("/cohorte/{id}")
    public Cohorte actualizar(@PathVariable("id") Long id, @RequestBody CohorteDTO body){
        return this.cohService.actualizar(id, body);
    }
    @DeleteMapping("/Cohorte/{id}")
    public void eliminar(@PathVariable("id") Long id){
        this.cohService.eliminar(id);
    }

}

