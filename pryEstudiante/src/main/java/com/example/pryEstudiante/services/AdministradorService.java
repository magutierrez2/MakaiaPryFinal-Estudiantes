package com.example.pryEstudiante.services;

import com.example.pryEstudiante.dtos.AdministradorDTO;
import com.example.pryEstudiante.entities.Administrador;
import com.example.pryEstudiante.exceptions.ExceptionApi;
import com.example.pryEstudiante.repositories.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class AdministradorService {
    @Autowired
    AdministradorRepository admRepository;

    public AdministradorService(AdministradorRepository admRepository){
        this.admRepository = admRepository;
    }
    public Administrador crearAdministrador(AdministradorDTO dto){
        Administrador admin = new Administrador(dto.getNombre(),dto.getUsuario_admin(),dto.getContrasena_admin());
        admin = this.admRepository.save(admin);
        return admin;
    }
    public Administrador buscarPorId(Long admin_id){
        Optional<Administrador> adminExiste = this.admRepository.findById(admin_id);
        if (adminExiste.isPresent()){
            return adminExiste.get();
        }else {
            throw new ExceptionApi("No existe un administrador con ese id" + admin_id);
        }
    }
    public List<Administrador> listarAdministrador(){
        List<Administrador> resultado = StreamSupport
                .stream(this.admRepository.findAll().spliterator(),false)
                .toList();
        return resultado;
    }
    public Administrador actualizarAdministrador(Long admin_id, AdministradorDTO dto){
        Optional<Administrador> adminExiste = this.admRepository.findById(admin_id);
        if (adminExiste.isPresent()){
            adminExiste.get().setNombre(dto.getNombre());
            adminExiste.get().setUsuario_admin(dto.getUsuario_admin());
            adminExiste.get().setContrasena_admin(dto.getContrasena_admin());
            return this.admRepository.save(adminExiste.get());
        }else {
            throw new ExceptionApi("No existe un administrador con ese id" + admin_id);
        }
    }
    public void eliminarAdministrador(Long admin_id){
        this.admRepository.deleteById(admin_id);
    }

}
