package com.example.pryEstudiante.services;
import com.example.pryEstudiante.dtos.AspiranteDTO;
import com.example.pryEstudiante.entities.Aspirante;
import com.example.pryEstudiante.repositories.AspiranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class AspiranteService {
    @Autowired
    AspiranteRepository aspRepository;

    public AspiranteService(AspiranteRepository aspRepository){
        this.aspRepository = aspRepository;
    }

    public Aspirante crearAspirante(AspiranteDTO dto){
        Aspirante aspirante = new Aspirante(dto.getCedula(), dto.getNombre(), dto.getApellido(), dto.getCorreo(), dto.getDireccion(), dto.getTelefono());
        aspirante = this.aspRepository.save(aspirante);
        return aspirante;
    }
    public List<Aspirante> listarAspirante(){
        List<Aspirante> resultado = StreamSupport
                .stream(this.aspRepository.findAll().spliterator(),false)
                .toList();
        return resultado;
    }

}
