package com.example.pryEstudiante.repositories;

import com.example.pryEstudiante.entities.Estudiante;
import org.springframework.data.repository.CrudRepository;


public interface EstudianteRepository extends CrudRepository<Estudiante, Long> {
}
