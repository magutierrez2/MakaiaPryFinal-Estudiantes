package com.example.pryEstudiante.controllers;
import com.example.pryEstudiante.dtos.AspiranteDTO;
import com.example.pryEstudiante.entities.Aspirante;
import com.example.pryEstudiante.services.AspiranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/aspirante")
public class AspiranteController {
    @Autowired
    AspiranteService aspiranteService;

    @PostMapping("/crearAspi")
    public ResponseEntity<String> crearAspi(@RequestBody AspiranteDTO dto){
        return aspiranteService.crearAspirante(dto);
    }
    @PostMapping(value = "/subirDocumentos", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadDoc(@RequestParam("Acta") MultipartFile file, @RequestParam("fileCedula") MultipartFile fileCedula, @RequestParam("cedula") String cedula) throws Exception {
        return aspiranteService.subirDocumentacion(file, fileCedula,cedula);
    }
    @GetMapping
    public List<Aspirante> listarAspi(){
        return this.aspiranteService.listarAspirante();
    }
}
