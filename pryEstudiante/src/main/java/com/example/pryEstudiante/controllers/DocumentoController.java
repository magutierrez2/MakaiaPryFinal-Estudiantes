package com.example.pryEstudiante.controllers;
import com.example.pryEstudiante.dtos.DocumentoDTO;
import com.example.pryEstudiante.entities.Documento;
import com.example.pryEstudiante.services.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/documento")
public class DocumentoController{
    private DocumentoService docService;

  /*  @Autowired
    public DocumentoController(DocumentoService docService){
        this.docService = docService;
    }

    @PostMapping()
    public Documento crear(@RequestBody DocumentoDTO dto){
        return this.docService.crear(dto);
    }
    @GetMapping()
    public List<Documento> listar(){
        return this.docService.listar();
    }
    @GetMapping("/documento/{id}")
    public Optional<Documento> buscar(@PathVariable("id") Long id){
        return this.docService.buscar(id);
    }
    @PutMapping("/documento/{id}")
    public Documento actualizar(@PathVariable("id") Long id, @RequestBody DocumentoDTO body){
        return this.docService.actualizar(id, body);
    }
    @DeleteMapping("/documento/{id}")
    public void eliminar(@PathVariable("id") Long id){
        this.docService.eliminar(id);
    }


   */
}
