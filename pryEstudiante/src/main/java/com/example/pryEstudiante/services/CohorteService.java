package com.example.pryEstudiante.services;

import com.example.pryEstudiante.dtos.CohorteDTO;
import com.example.pryEstudiante.entities.Estudiante;
import com.example.pryEstudiante.entities.Cohorte;
import com.example.pryEstudiante.exceptions.CohorteException;
import com.example.pryEstudiante.repositories.EstudianteRepository;
import com.example.pryEstudiante.repositories.CohorteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class CohorteService {

    CohorteRepository cohRepository;
    EstudianteRepository estRepository;

    @Autowired
    public CohorteService(CohorteRepository cohRepository, EstudianteRepository estRepository) {
        this.cohRepository = cohRepository;
        this.estRepository = estRepository;
    }

    public Cohorte crear(CohorteDTO dto) {
        Estudiante estudiante = this.estRepository
                .findById(dto.getId())
                .orElseThrow(() -> new CohorteException("El estudiante no existe", HttpStatus.BAD_REQUEST));
        Cohorte nuevoCohorte = new Cohorte(dto.getNombre(),  dto.getFechaInicio(),  estudiante );
        return this.cohRepository.save(nuevoCohorte);
    }

    public List<Cohorte> listar() {
        List<Cohorte> result = StreamSupport
                .stream(this.cohRepository.findAll().spliterator(), false)
                .toList();
        return result;
    }

    public void eliminar(Long cohorteId) {
        this.cohRepository.deleteById(cohorteId);
    }

    public Optional<Cohorte> buscar(Long cohorteId) {
        return this.cohRepository.findById(cohorteId);
    }

    public Cohorte actualizar(Long cohorteId, CohorteDTO dto) {
        Cohorte cohorteExistente = this.cohRepository.findById(cohorteId)
                .orElseThrow(() -> new CohorteException("El cohorte no existe"));


        cohorteExistente.setNombre(dto.getNombre());
        cohorteExistente.setFechaInicio(dto.getFechaInicio());

        return this.cohRepository.save(cohorteExistente);
    }
}
