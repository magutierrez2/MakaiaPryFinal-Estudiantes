package com.example.pryEstudiante.controllers;

import com.example.pryEstudiante.dtos.DocumentoDTO;
import com.example.pryEstudiante.dtos.EstadoDocumento;
import com.example.pryEstudiante.entities.Documento;
import com.example.pryEstudiante.services.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/documento")
public class DocumentoController {
    @Autowired
    DocumentoService docService;


    @PostMapping(value = "/crear")
    public Documento crearDoc(@RequestBody DocumentoDTO dto){
        return this.docService.crearDocumento(dto);
    }
    /*@PostMapping(value = "/subirDocumentos", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadDoc(@RequestParam("Acta") MultipartFile file, @RequestParam("Cedula") MultipartFile cedula, @RequestParam("identificadorRuta") String identificadorRuta) throws Exception {
        return new ResponseEntity<>(docService.subirArchivos(file, cedula,identificadorRuta), HttpStatus.OK);
    }*/

    @PutMapping("/cambiarEstado")
    public ResponseEntity<String> estadoDocumento(@RequestParam Long id, @RequestParam EstadoDocumento estado){
        return docService.estadoDocumento(id,estado);
    }

    @GetMapping
    public List<Documento> listarDoc(){
        return this.docService.listarDocumento();
    }
}
