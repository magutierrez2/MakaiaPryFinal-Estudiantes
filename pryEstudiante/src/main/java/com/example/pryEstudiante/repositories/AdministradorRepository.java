package com.example.pryEstudiante.repositories;

import com.example.pryEstudiante.entities.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
   Optional<Administrador> findById (Long id);
}
