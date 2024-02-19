package com.example.pryEstudiante.repositories;

import com.example.pryEstudiante.entities.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento,Long> {
}
