package com.example.pryEstudiante.services;

import com.example.pryEstudiante.dtos.EstudianteDTO;
import com.example.pryEstudiante.entities.Aspirante;
import com.example.pryEstudiante.entities.Cohorte;
import com.example.pryEstudiante.entities.Estudiante;
import com.example.pryEstudiante.exceptions.ExceptionApi;
import com.example.pryEstudiante.repositories.AspiranteRepository;
import com.example.pryEstudiante.repositories.CohorteRepository;
import com.example.pryEstudiante.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class EstudianteService {
    @Autowired
    EstudianteRepository estRepository;
    CohorteRepository cohorteRepository;
    AspiranteRepository aspRepository;

    public EstudianteService(EstudianteRepository estRepository, CohorteRepository cohorteRepository, AspiranteRepository aspRepository){
        this.estRepository = estRepository;
        this.cohorteRepository = cohorteRepository;
        this.aspRepository = aspRepository;
    }
    public Estudiante crearEstudiante(EstudianteDTO dto){
        Optional<Aspirante> aspiranteOptional = aspRepository.findById(dto.getObjAspirante().getAspi_id());
        if (!aspiranteOptional.isPresent()){
            throw new ExceptionApi("No existe una cohorte con ese id" + aspiranteOptional.get().getAspi_id());
        }
        Aspirante aspirante = aspiranteOptional.get();
        Optional<Cohorte> cohorteOptional = cohorteRepository.findById(dto.getObjCohorte().getId_cohorte());
        if (!cohorteOptional.isPresent()){
            throw new ExceptionApi("No existe una cohorte con ese id" + cohorteOptional.get().getId_cohorte());
        }
        Cohorte cohorte = cohorteOptional.get();
        Estudiante estudiante = new Estudiante(dto.getUsuario_estudiante(), dto.getContrasena_estudiante(), cohorte, aspirante);
        estudiante = this.estRepository.save(estudiante);
        return estudiante;
    }
    public List<Estudiante> listarEstudiante(){
        List<Estudiante> resultado = StreamSupport
                .stream(this.estRepository.findAll().spliterator(),false)
                .toList();
        return resultado;
    }
}
