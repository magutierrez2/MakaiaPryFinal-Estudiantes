package com.example.pryEstudiante.controllers;
import com.example.pryEstudiante.dtos.AdministradorDTO;
import com.example.pryEstudiante.entities.Administrador;
import com.example.pryEstudiante.services.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/administrador")
public class AdministradorController {
    @Autowired
    private AdministradorService adminService;

    @PostMapping
    public Administrador crearAdmin(@RequestBody AdministradorDTO dto){
        return this.adminService.crearAdministrador(dto);
    }
    @GetMapping("/{admin_id}")
    public Administrador buscarAdminId(@PathVariable("admin_id") Long id){
        return this.adminService.buscarPorId(id);
    }
    @GetMapping
    public List<Administrador> listarAdmin(){
        return this.adminService.listarAdministrador();
    }
    @PutMapping("/{admin_id}/actualizar")
    public Administrador actualizarAdmin(@PathVariable("admin_id") Long id, @RequestBody AdministradorDTO dto){
        return this.adminService.actualizarAdministrador(id,dto);
    }
    @DeleteMapping("{admin_id}/eliminar")
    public void eliminarAdmin(@PathVariable("admin_id") Long id){
        this.adminService.eliminarAdministrador(id);
    }
}
