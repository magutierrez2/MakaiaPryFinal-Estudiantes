package com.example.pryEstudiante.controllers;

import com.example.pryEstudiante.dtos.AdministradorDTO;
import com.example.pryEstudiante.entities.Administrador;
import com.example.pryEstudiante.services.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {
    @Autowired
    private AdministradorService administradorService;

    @GetMapping("/{id}")
    public ResponseEntity<AdministradorDTO> getAdministrador(@PathVariable Long id) {
        Administrador administrador = administradorService.getAdministrador(id);
        AdministradorDTO administradorDTO = mapToDTO(administrador);
        return ResponseEntity.ok(administradorDTO);
    }

    // Otros métodos para CRUD, manipulación de cohortes, etc.

    private AdministradorDTO mapToDTO(Administrador administrador) {
        // Implementa la lógica para mapear la entidad a un DTO
    }
}
}
