package com.example.pryEstudiante.services;

import com.example.pryEstudiante.dtos.AspiranteDTO;
import com.example.pryEstudiante.entities.Aspirante;
import com.example.pryEstudiante.entities.Documento;
import com.example.pryEstudiante.exceptions.DocumentoException;
import com.example.pryEstudiante.repositories.AspiranteRepository;
import com.example.pryEstudiante.repositories.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;

@org.springframework.stereotype.Service
public class AspiranteService {
    AspiranteRepository aspRepository;
    DocumentoRepository docRepository;

    @Autowired
    public AspiranteService(AspiranteRepository aspRepository, DocumentoRepository docRepository){
        this.aspRepository = aspRepository;
        this.docRepository = docRepository;
    }


}
