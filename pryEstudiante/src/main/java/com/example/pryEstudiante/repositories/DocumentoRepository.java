package com.example.pryEstudiante.repositories;

import com.example.pryEstudiante.entities.Documento;
import org.springframework.data.repository.CrudRepository;

public interface DocumentoRepository extends CrudRepository<Documento, Long> {
}
