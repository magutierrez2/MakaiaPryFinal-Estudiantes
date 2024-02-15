package com.example.pryEstudiante.services;

import com.example.pryEstudiante.dtos.EstudianteDTO;
import com.example.pryEstudiante.entities.Aspirante;
import com.example.pryEstudiante.entities.Estudiante;
import com.example.pryEstudiante.exceptions.EstudianteException;
import com.example.pryEstudiante.repositories.EstudianteRepository;
import com.example.pryEstudiante.repositories.AspiranteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@org.springframework.stereotype.Service
public class EstudianteService {

    EstudianteRepository estRepository;
    AspiranteRepository aspRepository;

    @Autowired
    public EstudianteService (EstudianteRepository estRepository ,  AspiranteRepository aspRepository){
        this.estRepository=estRepository;
        this.aspRepository=aspRepository;

    }

    ////public Estudiante crear(EstudianteDTO dto) {
    //    Optional<Aspirante> aspirante = this.aspRepository.findById(dto.getId());
    //
    //    if (aspirante.isEmpty()) {
    //        throw new EstudianteException("El aspirante no exixte", HttpStatusCode.valueOf(400));
    //    }
    //
    //    Estudiante nuevoEstudiante = new Estudiante(dto.getUsuario(), dto.getContrasena());
    //    return this.estRepository.save(nuevoEstudiante);
    //}
   /* public Estudiante crear(EstudianteDTO dto){
        Aspirante aspirante = this.aspRepository
                .findById(dto.getId())
                .orElseThrow(()-> new EstudianteException("El aspirante no exixte", HttpStatusCode.valueOf(400)));
        Estudiante nuevoEstudiante = new Estudiante(dto.getUsuario(), dto.getContrasena());
        return this.estRepository.save(nuevoEstudiante);
    }
    public List<Estudiante> listar(){
        List<Estudiante> result = StreamSupport
                .stream(this.estRepository.findAll().spliterator(),false)
                .toList();
        return result;
    }
    public void eliminar(Long estudianteId){
        this.estRepository.deleteById(estudianteId);
    }
    public Optional<Estudiante> buscar(Long estudianteId){
        return this.estRepository.findById(estudianteId);
    }
    public Estudiante actualizar(Long estudianteId, EstudianteDTO dto){
        Estudiante estExiste = this.estRepository.findById(estudianteId)
                .orElseThrow(() -> new EstudianteException("El estudiante no existe"));

        estExiste.setUsuario(dto.getUsuario());
        estExiste.setContrasena(dto.getContrasena());

        return this.estRepository.save(estExiste);
    }

    */
}
