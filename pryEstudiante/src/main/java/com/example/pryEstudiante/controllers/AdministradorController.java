package com.example.pryEstudiante.controllers;
import com.example.pryEstudiante.dtos.AdministradorDTO;
import com.example.pryEstudiante.entities.Administrador;
import com.example.pryEstudiante.services.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/administrador")
public class AdministradorController{

    @Autowired
    private AdministradorService admService;

    @PostMapping
    public  Administrador crearAdmin (@RequestBody AdministradorDTO dto){
        return this.admService.crearAdministrador(dto);
    }

    @GetMapping
    public List<Administrador> listarAdmin (){
        return this.admService.listarAdministrador();
    }
    @GetMapping("/{adminId}")
    public Administrador buscarIdadmin (@PathVariable("adminId") Long id){
        return this.admService.buscarId(id);
    }

    @PutMapping("/{adminId}/actualizar")
    public Administrador actualizarAdmin (@PathVariable("adminId") Long id, @RequestBody AdministradorDTO dto){
        return this.admService.actualizarAdministrador(id,dto);
    }

    @DeleteMapping("/{adminId}/eliminar")
    public void eliminarAdmin (@PathVariable("adminId") Long id){
        this.admService.eliminarAdministrador(id);
    }
}
