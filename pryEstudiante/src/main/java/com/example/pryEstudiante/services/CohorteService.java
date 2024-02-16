package com.example.pryEstudiante.services;

import com.example.pryEstudiante.dtos.CohorteDTO;
import com.example.pryEstudiante.entities.Cohorte;
import com.example.pryEstudiante.repositories.CohorteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class CohorteService {
    @Autowired
    CohorteRepository cohorteRepository;

    public CohorteService(CohorteRepository cohorteRepository) {
        this.cohorteRepository = cohorteRepository;
    }

    public Cohorte crearCohorte(CohorteDTO dto){
        Cohorte cohorte = new Cohorte(dto.getNombre(),dto.getFecha_inicio());
        cohorte = this.cohorteRepository.save(cohorte);
        return cohorte;
    }
    public List<Cohorte> listarCohorte(){
        List<Cohorte> resultado = StreamSupport
                .stream(this.cohorteRepository.findAll().spliterator(),false)
                .toList();
        return resultado;
    }
}
