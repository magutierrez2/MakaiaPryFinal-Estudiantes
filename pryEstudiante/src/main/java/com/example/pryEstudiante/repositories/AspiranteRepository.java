package com.example.pryEstudiante.repositories;

import com.example.pryEstudiante.entities.Aspirante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AspiranteRepository extends CrudRepository<Aspirante, Long> {
}
