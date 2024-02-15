package com.example.pryEstudiante.services;

import com.example.pryEstudiante.dtos.AdministradorDTO;
import com.example.pryEstudiante.dtos.AspiranteDTO;
import com.example.pryEstudiante.entities.Administrador;
import com.example.pryEstudiante.entities.Aspirante;
import com.example.pryEstudiante.exceptions.AdministradorException;
import com.example.pryEstudiante.repositories.AdministradorRepository;
import com.example.pryEstudiante.repositories.AspiranteRepository;
import com.example.pryEstudiante.repositories.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AspiranteService {
    @Autowired
    AspiranteRepository aspRepository;
    AdministradorRepository administradorRepository;
    DocumentoRepository documentoRepository;
    public ArrayList<Aspirante> getAspirantes(){
        return (ArrayList<Aspirante>) aspRepository.findAll();
    }
    public Aspirante crearAspirante (AspiranteDTO dto){

        Aspirante aspirante = new Aspirante(dto.getNombre(),dto.getApellido(), dto.getCorreo(), dto.getDireccion(), dto.getTelefono());
        aspirante = this.aspRepository.save(aspirante);
        return aspirante;

    }
}
