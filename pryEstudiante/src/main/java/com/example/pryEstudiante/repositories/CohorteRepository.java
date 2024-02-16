package com.example.pryEstudiante.repositories;

import com.example.pryEstudiante.entities.Cohorte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CohorteRepository extends JpaRepository<Cohorte, Long> {
}
