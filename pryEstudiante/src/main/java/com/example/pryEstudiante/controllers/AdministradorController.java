package com.example.pryEstudiante.controllers;
import com.example.pryEstudiante.dtos.AdministradorDTO;
import com.example.pryEstudiante.entities.Administrador;
import com.example.pryEstudiante.services.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api/v1/administrador")
public class AdministradorController{

    @Autowired
    private AdministradorService admService;
   /* @PostMapping
    public  Administrador crearAdmin (@RequestBody AdministradorDTO dto){
        return this.admService.crearAdministrador(dto);
    }

    */
}
