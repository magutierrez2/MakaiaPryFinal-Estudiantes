package com.example.pryEstudiante.repositories;

import com.example.pryEstudiante.entities.Cohorte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CohorteRepository extends JpaRepository<Cohorte, Long> {
}

