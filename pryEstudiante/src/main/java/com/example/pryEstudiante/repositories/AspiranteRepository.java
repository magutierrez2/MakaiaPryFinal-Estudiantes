package com.example.pryEstudiante.repositories;

import com.example.pryEstudiante.entities.Aspirante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AspiranteRepository extends JpaRepository<Aspirante, Long> {
    @Override
    Optional<Aspirante> findById(Long id);
}
