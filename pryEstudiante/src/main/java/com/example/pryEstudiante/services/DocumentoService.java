package com.example.pryEstudiante.services;

import com.example.pryEstudiante.dtos.DocumentoDTO;
import com.example.pryEstudiante.entities.Aspirante;
import com.example.pryEstudiante.entities.Documento;
import com.example.pryEstudiante.exceptions.DocumentoException;
import com.example.pryEstudiante.repositories.AspiranteRepository;
import com.example.pryEstudiante.repositories.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@org.springframework.stereotype.Service
public class DocumentoService {

    DocumentoRepository docRepository;
    AspiranteRepository aspRepository;

    @Autowired
    public DocumentoService(DocumentoRepository docRepository, AspiranteRepository aspRepository){
        this.docRepository=docRepository;
        this.aspRepository=aspRepository;
    }
    public Documento crearDocumento(DocumentoDTO dto){
        Aspirante aspirante = this.aspRepository
                .findById(dto.getId())
                .orElseThrow(()-> new DocumentoException("El aspirante no exixte", HttpStatusCode.valueOf(400)));
        Documento nuevoDocumento = new Documento(dto.getNombre(), dto.getTipoContenido(), dto.getFechaCreacion(), dto.getFechaActualizacion(), aspirante);
        return this.docRepository.save(nuevoDocumento);
    }
    public List<Documento> listar(){
        List<Documento> result = StreamSupport
                .stream(this.docRepository.findAll().spliterator(),false)
                .toList();
        return result;
    }
    public void eliminar(Long documentoId){
        this.docRepository.deleteById(documentoId);
    }
    public Optional<Documento> buscar(Long documentoId){
        return this.docRepository.findById(documentoId);
    }
    public Documento actualizar(Long documentoId, DocumentoDTO dto){
        Documento docExiste = this.docRepository.findById(documentoId)
                .orElseThrow(() -> new DocumentoException("El documento no existe"));
        Aspirante aspExiste = this.aspRepository.findById(dto.getAspiranteId())
                .orElseThrow(() -> new DocumentoException("El aspirante no existe"));
        docExiste.setNombre(dto.getNombre());
        docExiste.setTipoContenido(dto.getTipoContenido());
        docExiste.setFechaCreacion(dto.getFechaCreacion());
        docExiste.setFechaActualizacion(dto.getFechaActualizacion());
        docExiste.setAspirante(aspExiste);
        return this.docRepository.save(docExiste);
    }
}
