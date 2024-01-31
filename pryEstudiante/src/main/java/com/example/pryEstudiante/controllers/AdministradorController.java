package com.example.pryEstudiante.controllers;
import com.example.pryEstudiante.dtos.AdministradorDTO;
import com.example.pryEstudiante.entities.Administrador;
import com.example.pryEstudiante.services.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/administrador")
public class AdministradorController{
    private AdministradorService admService;

    @Autowired
    public AdministradorController(AdministradorService estService){
        this.admService = admService;
    }

    @PostMapping()
    public Administrador crear(@RequestBody AdministradorDTO dto){
        return this.admService.crear(dto);
    }
    @GetMapping()
    public List<Administrador> listar(){
        return this.admService.listar();
    }
    @GetMapping("/administrador/{id}")
    public Optional<Administrador> buscar(@PathVariable("id") Long id){
        return this.admService.buscar(id);
    }
    @PutMapping("/administrador/{id}")
    public Administrador actualizar(@PathVariable("id") Long id, @RequestBody AdministradorDTO body){
        return this.admService.actualizar(id, body);
    }
    @DeleteMapping("/administrador/{id}")
    public void eliminar(@PathVariable("id") Long id){
        this.admService.eliminar(id);
    }

}
