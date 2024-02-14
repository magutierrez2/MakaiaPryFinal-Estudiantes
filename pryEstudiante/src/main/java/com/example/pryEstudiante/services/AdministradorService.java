package com.example.pryEstudiante.services;
import com.example.pryEstudiante.entities.Administrador;
import com.example.pryEstudiante.dtos.AdministradorDTO;
import com.example.pryEstudiante.exceptions.AdministradorException;
import com.example.pryEstudiante.repositories.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@org.springframework.stereotype.Service
public class AdministradorService {

    AdministradorRepository admRepository;

    @Autowired
    public AdministradorService (AdministradorRepository admRepository){
        this.admRepository=admRepository;

    }
    public Administrador crear(AdministradorDTO dto){

        Administrador nuevoAdministrador = new Administrador(dto.getNombre(),dto.getUsuarioAdmin(), dto.getContrasenaAdmin());
        return this.admRepository.save(nuevoAdministrador);
    }
    public List<Administrador> listar(){
        List<Administrador> result = StreamSupport
                .stream(this.admRepository.findAll().spliterator(),false)
                .toList();
        return result;
    }
    public void eliminar(Long adminisrtradorId){
        this.admRepository.deleteById(adminisrtradorId);
    }
    public Optional<Administrador> buscar(Long administradorId){
        return this.admRepository.findById(administradorId);
    }
    public Administrador actualizar(Long administradorId, AdministradorDTO dto){
        Administrador admExiste = this.admRepository.findById(administradorId)
                .orElseThrow(() -> new AdministradorException("El Administrador no existe"));

        admExiste.setNombre(dto.getNombre());

        return this.admRepository.save(admExiste);
    }
}
