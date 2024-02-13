package com.example.pryEstudiante.repositories;

import com.example.pryEstudiante.entities.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    Administrador findbyId (Long id);
}
