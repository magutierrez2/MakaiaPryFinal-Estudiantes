package com.example.pryEstudiante.services;
import com.example.pryEstudiante.entities.Administrador;

import com.example.pryEstudiante.dtos.AdministradorDTO;
import com.example.pryEstudiante.exceptions.AdministradorException;
import com.example.pryEstudiante.repositories.AdministradorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class AdministradorService {

    AdministradorRepository admRepository;

    @Autowired
    public AdministradorService (AdministradorRepository admRepository){
        this.admRepository=admRepository;

    }
    public Administrador crearAdministrador (AdministradorDTO dto){
        Administrador administrador = new Administrador(dto.getNombre(),dto.getUsuarioAdmin(),dto.getContrasenaAdmin());
        administrador = this.admRepository.save(administrador);
        return  administrador;

    }

    public Administrador buscarId (Long administradorId){
        Administrador admExiste = this.admRepository.findById(administradorId)
                .orElseThrow(() -> new AdministradorException("El Administrador no existe"));
        return  admExiste;
    }

    public List<Administrador> listarAdministrador(){
        List<Administrador> result = StreamSupport
                .stream(this.admRepository.findAll().spliterator(),false)
                .toList();
        return result;
    }

    public Administrador actualizarAdministrador(Long administradorId, AdministradorDTO dto){
        Administrador admExiste = this.admRepository.findById(administradorId)
                .orElseThrow(() -> new AdministradorException("El Administrador no existe"));
        admExiste.setNombre(dto.getNombre());
        admExiste.setContrasenaAdmin(dto.getContrasenaAdmin());
        return this.admRepository.save(admExiste);
    }


    public void eliminarAdministrador(Long adminisrtradorId){
        this.admRepository.deleteById(adminisrtradorId);
    }



}
