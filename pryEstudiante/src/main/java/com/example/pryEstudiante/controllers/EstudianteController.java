package com.example.pryEstudiante.controllers;
import com.example.pryEstudiante.dtos.EstudianteDTO;
import com.example.pryEstudiante.entities.Estudiante;
import com.example.pryEstudiante.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/estudiante")
public class EstudianteController{
    private EstudianteService estService;

    @Autowired
    public EstudianteController(EstudianteService estService){
        this.estService = estService;
    }

    @PostMapping()
    public Estudiante crear(@RequestBody EstudianteDTO dto){
        return this.estService.crear(dto);
    }
    @GetMapping()
    public List<Estudiante> listar(){
        return this.estService.listar();
    }
    @GetMapping("/estudiante/{id}")
    public Optional<Estudiante> buscar(@PathVariable("id") Long id){
        return this.estService.buscar(id);
    }
    @PutMapping("/estudiante/{id}")
    public Estudiante actualizar(@PathVariable("id") Long id, @RequestBody EstudianteDTO body){
        return this.estService.actualizar(id, body);
    }
    @DeleteMapping("/estudiante/{id}")
    public void eliminar(@PathVariable("id") Long id){
        this.estService.eliminar(id);
    }

}
