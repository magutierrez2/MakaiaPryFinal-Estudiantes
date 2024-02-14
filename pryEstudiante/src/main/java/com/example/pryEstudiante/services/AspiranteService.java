package com.example.pryEstudiante.services;

import com.example.pryEstudiante.entities.Aspirante;
import com.example.pryEstudiante.repositories.AspiranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AspiranteService {
    @Autowired
    AspiranteRepository aspRepository;
    public ArrayList<Aspirante> getAspirantes(){
        return (ArrayList<Aspirante>) aspRepository.findAll();
    }

    public Aspirante saveAspirante(Aspirante aspirante){
        return aspRepository.save(aspirante);
    }
}
