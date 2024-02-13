package com.example.pryEstudiante.services;

import com.example.pryEstudiante.dtos.CohorteDTO;
import com.example.pryEstudiante.entities.Cohorte;
import com.example.pryEstudiante.exceptions.CohorteException;
import com.example.pryEstudiante.repositories.AdministradorRepository;
import com.example.pryEstudiante.repositories.EstudianteRepository;
import com.example.pryEstudiante.repositories.CohorteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.pryEstudiante.entities.Administrador;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CohorteService {


    CohorteRepository cohRepository;

    EstudianteRepository estRepository;
    AdministradorRepository adminRepository;

    @Autowired
    public CohorteService(CohorteRepository cohRepository, EstudianteRepository estRepository, AdministradorRepository adminRepository) {
        this.cohRepository = cohRepository;
        this.estRepository = estRepository;
        this.adminRepository = adminRepository;
    }



    public void eliminar(Long cohorteId) {
        this.cohRepository.deleteById(cohorteId);
    }

    public Optional<Cohorte> buscar(Long cohorteId) {
        return this.cohRepository.findById(cohorteId);
    }

  /*  public Cohorte actualizar(Long cohorteId, CohorteDTO dto) {
        Cohorte cohorteExistente = this.cohRepository.findById(cohorteId)
                .orElseThrow(() -> new CohorteException("El cohorte no existe"));


        cohorteExistente.setNombre(dto.getNombre());
        cohorteExistente.setFechaInicio(dto.getFechaInicio());

        return this.cohRepository.save(cohorteExistente);
    }

   */
}
