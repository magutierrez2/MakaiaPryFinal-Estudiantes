package com.example.pryEstudiante.controllers;

import com.example.pryEstudiante.dtos.EstudianteDTO;
import com.example.pryEstudiante.entities.Estudiante;
import com.example.pryEstudiante.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/estudiante")
public class EstudianteController {
    @Autowired
    EstudianteService estService;

    @PostMapping
    public Estudiante crearEst(@RequestBody EstudianteDTO dto){
        return this.estService.crearEstudiante(dto);
    }
    @GetMapping
    public List<Estudiante> listarEst(){
        return this.estService.listarEstudiante();
    }

    @PostMapping("/asignarCohorte")
    public ResponseEntity asignarCohorte(@RequestParam("Id_Aspirante") Long idAspirante, @RequestParam("Id_Cohorte") Long idCohorte){
        return this.estService.asignarCohorte(idAspirante,idCohorte);
    }

}
