package com.example.pryEstudiante.services;

import com.example.pryEstudiante.dtos.DocumentoDTO;
import com.example.pryEstudiante.entities.Administrador;
import com.example.pryEstudiante.entities.Aspirante;
import com.example.pryEstudiante.entities.Documento;
import com.example.pryEstudiante.exceptions.AdministradorException;
import com.example.pryEstudiante.exceptions.DocumentoException;
import com.example.pryEstudiante.repositories.AdministradorRepository;
import com.example.pryEstudiante.repositories.AspiranteRepository;
import com.example.pryEstudiante.repositories.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class DocumentoService {

    DocumentoRepository docRepository;
    AspiranteRepository aspRepository;
    AdministradorRepository admRepository;

    @Autowired
    public DocumentoService(DocumentoRepository docRepository, AspiranteRepository aspRepository, AdministradorRepository admRepository){
        this.docRepository=docRepository;
        this.aspRepository=aspRepository;
        this.admRepository=admRepository;
    }
    public Documento crearDocumento(DocumentoDTO dto){
        Aspirante aspExiste = this.aspRepository.findById(dto.getAspirante().getId())
                .orElseThrow(() -> new DocumentoException("No existe el aspirante"));

        Administrador admExiste = admRepository.findById(dto.getAdministrador().getId())
                .orElseThrow(() -> new DocumentoException("No existe el administrador"));

        Documento nuevoDoc = new Documento(dto.getTipo(),dto.getContenido(), dto.getEstado(), aspExiste,admExiste);
        nuevoDoc = this.docRepository.save(nuevoDoc);
        return nuevoDoc;
    }
    public List<Documento> listar(){
        List<Documento> result = StreamSupport
                .stream(this.docRepository.findAll().spliterator(),false)
                .toList();
        return result;
    }
    /*
    public void eliminar(Long documentoId){
        this.docRepository.deleteById(documentoId);
    }
    public Optional<Documento> buscar(Long documentoId){
        return this.docRepository.findById(documentoId);
    }
    public Documento actualizar(Long documentoId, DocumentoDTO dto){
        Documento docExiste = this.docRepository.findById(documentoId)
                .orElseThrow(() -> new DocumentoException("El documento no existe"));
        Aspirante aspExiste = this.aspRepository.findByIdAspirante(dto.getAspiranteId());
        if (aspExiste != null){
            throw new DocumentoException("El aspirante no exixte", HttpStatusCode.valueOf(400));
        }

        docExiste.setNombre(dto.getNombre());
        docExiste.setTipoContenido(dto.getTipoContenido());
        docExiste.setFechaCreacion(dto.getFechaCreacion());
        docExiste.setFechaActualizacion(dto.getFechaActualizacion());
        docExiste.setAspirante(aspExiste);
        return this.docRepository.save(docExiste);
    }*/
}
