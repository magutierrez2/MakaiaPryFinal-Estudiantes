package com.example.pryEstudiante.repositories;

import com.example.pryEstudiante.entities.Aspirante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AspiranteRepository extends JpaRepository<Aspirante, Long> {
    @Query
    Optional<Aspirante> findByCorreo(String correo);

    @Query
    Optional<Aspirante> findByCedula(String cedula);
}
