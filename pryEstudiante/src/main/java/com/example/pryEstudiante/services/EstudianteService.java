package com.example.pryEstudiante.services;

import com.example.pryEstudiante.dtos.*;
import com.example.pryEstudiante.entities.Aspirante;
import com.example.pryEstudiante.entities.Cohorte;
import com.example.pryEstudiante.entities.Estudiante;
import com.example.pryEstudiante.exceptions.ExceptionApi;
import com.example.pryEstudiante.repositories.AspiranteRepository;
import com.example.pryEstudiante.repositories.CohorteRepository;
import com.example.pryEstudiante.repositories.EstudianteRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class EstudianteService {
    @Autowired
    EstudianteRepository estRepository;
    CohorteRepository cohorteRepository;
    AspiranteRepository aspRepository;
    IEmailService emailService;

    public EstudianteService(EstudianteRepository estRepository, CohorteRepository cohorteRepository, AspiranteRepository aspRepository, IEmailService emailService){
        this.estRepository = estRepository;
        this.cohorteRepository = cohorteRepository;
        this.aspRepository = aspRepository;
        this.emailService = emailService;
    }
    public Estudiante crearEstudiante(EstudianteDTO dto){
        Optional<Aspirante> aspOptional = aspRepository.findById(dto.getObjAspirante().getAspi_id());
        if (!aspOptional.isPresent()){
            throw new ExceptionApi("No existe un aspitante con ese id" + aspOptional.get().getAspi_id());
        }
        Aspirante aspirante = aspOptional.get();
        Optional<Cohorte> cohOptional = cohorteRepository.findById(dto.getObjCohorte().getId_cohorte());
        if (!cohOptional.isPresent()){
            throw new ExceptionApi("No existe una cohorte con ese id" + cohOptional.get().getId_cohorte());
        }
        Cohorte cohorte = cohOptional.get();
        Estudiante estudiante = new Estudiante(dto.getUsuario_estudiante(), dto.getContrasena_estudiante(), cohorte, aspirante);
        estudiante = this.estRepository.save(estudiante);
        return estudiante;
    }
    public ResponseEntity<String> asignarCohorte(Long id_aspi, Long id_cohorte){
        Optional<Aspirante> aspOptional = aspRepository.findById(id_aspi);
        if (!aspOptional.isPresent()){
            return ResponseEntity.ok("No existe un aspitante con ese id" + id_aspi);
        }
        Optional<Cohorte> cohOptional = cohorteRepository.findById(id_cohorte);
        if (!cohOptional.isPresent()){
            return ResponseEntity.ok("No existe una cohorte con ese id" + id_cohorte);
        }
        if(aspOptional.get().getDocumentos().size() != 0) {
            if (aspOptional.get().getDocumentos().get(0).getEstado() == EstadoDocumento.ACEPTADO) {
                String usuario = aspOptional.get().getCorreo().split("@")[0];
                String contrasenia = generarContraseña(8);
                CohorteDTO cohorteDTO = new CohorteDTO(cohOptional.get().getNombre(), cohOptional.get().getFecha_inicio());
                cohorteDTO.setId_cohorte(cohOptional.get().getId_cohorte());
                AspiranteDTO aspiranteDTO = new AspiranteDTO(aspOptional.get().getCedula(), aspOptional.get().getNombre(), aspOptional.get().getApellido(),
                        aspOptional.get().getCorreo(), aspOptional.get().getDireccion(), aspOptional.get().getTelefono());
                aspiranteDTO.setAspi_id(aspOptional.get().getAspi_id());
                EstudianteDTO estudianteDTO = new EstudianteDTO(usuario, contrasenia, cohorteDTO, aspiranteDTO);
                this.crearEstudiante(estudianteDTO);
                String asunto = "\uD83D\uDE80 Acceso a la Plataforma de Entrenamiento y Credenciales de Inicio de Sesión \uD83C\uDF93";
                String plantillaMensaje = "mensajeCredenciales";
                HashMap<String, String> info = new HashMap<>();
                info.put("nombre", aspiranteDTO.getNombre());
                info.put("apellido", aspiranteDTO.getApellido());
                info.put("usuario", usuario);
                info.put("contrasenia", contrasenia);
                EmailDTO email = new EmailDTO(aspiranteDTO.getCorreo(), asunto, plantillaMensaje);
                email.setInfoMensaje(info);
                try {
                    emailService.sendMail(email);
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
                return ResponseEntity.ok("Se creo el estudiante con sus credenciales exitosamente");
            }
            return ResponseEntity.ok("El aspirante no cuenta con documentos en estado ACEPTADOS");
        }
        return ResponseEntity.ok("El aspirante no tiene con documentos ");
    }
    private String generarContraseña(int longitud){
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+=-";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(longitud);
        // Generar la contraseña aleatoria
        for (int i = 0; i < longitud; i++) {
            int indice = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(indice));
        }
        return sb.toString();
    }
    public List<Estudiante> listarEstudiante(){
        List<Estudiante> resultado = StreamSupport
                .stream(this.estRepository.findAll().spliterator(),false)
                .toList();
        return resultado;
    }
}
