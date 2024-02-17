package com.example.pryEstudiante.services;

import com.example.pryEstudiante.dtos.DocumentoDTO;
import com.example.pryEstudiante.entities.Aspirante;
import com.example.pryEstudiante.entities.Documento;
import com.example.pryEstudiante.exceptions.ExceptionApi;
import com.example.pryEstudiante.repositories.AspiranteRepository;
import com.example.pryEstudiante.repositories.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Repository
public class DocumentoService {
    @Autowired
    DocumentoRepository docRepository;
    AspiranteRepository aspRepository;

    public DocumentoService(DocumentoRepository docRepository, AspiranteRepository aspRepository) {
        this.aspRepository = aspRepository;
        this.docRepository = docRepository;
    }
    public Documento crearDocumento(DocumentoDTO dto){

        Optional<Aspirante> aspiranteOptional = aspRepository.findById(dto.getObjAspirante().getAspi_id());
        if (!aspiranteOptional.isPresent())
        {
            throw new ExceptionApi("No existe un aspirante con ese id" + aspiranteOptional.get().getAspi_id());
        }
        Aspirante aspirante = aspiranteOptional.get();
        Documento documento = new Documento(dto.getNombre_documento(), dto.getContenido_documento(), dto.getEstado(), aspirante);
        documento = this.docRepository.save(documento);
        return documento;
    }
    public List<Documento> listarDocumento(){
        List<Documento> resultado = StreamSupport
                .stream(this.docRepository.findAll().spliterator(),false)
                .toList();
        return resultado;
    }
}
