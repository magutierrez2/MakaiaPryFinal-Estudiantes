package com.example.pryEstudiante.services;

import com.example.pryEstudiante.dtos.DocumentoDTO;
import com.example.pryEstudiante.dtos.EmailDTO;
import com.example.pryEstudiante.dtos.EstadoDocumento;
import com.example.pryEstudiante.entities.Aspirante;
import com.example.pryEstudiante.entities.Documento;
import com.example.pryEstudiante.exceptions.ExceptionApi;
import com.example.pryEstudiante.repositories.AspiranteRepository;
import com.example.pryEstudiante.repositories.DocumentoRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;

@Repository
public class DocumentoService {
    @Autowired
    DocumentoRepository docRepository;
    AspiranteRepository aspRepository;
    IEmailService emailService;

    public DocumentoService(DocumentoRepository docRepository, AspiranteRepository aspRepository, IEmailService emailService) {
        this.aspRepository = aspRepository;
        this.docRepository = docRepository;
        this.emailService = emailService;
    }
    public Documento crearDocumento(DocumentoDTO dto){

        Optional<Aspirante> aspiranteOptional = aspRepository.findById(dto.getObjAspirante().getAspi_id());
        if (!aspiranteOptional.isPresent())
        {
            throw new ExceptionApi("No existe un aspirante con ese id" + aspiranteOptional.get().getAspi_id());
        }
        Aspirante aspirante = aspiranteOptional.get();
        Documento documento = new Documento(dto.getNombre_documento(), dto.getruta_archivo(), dto.getEstado(), aspirante);
        documento = this.docRepository.save(documento);
        return documento;
    }

    public DocumentoDTO guardarArchivoLocal(MultipartFile file, String identificadorRuta) throws Exception {
        DocumentoDTO documento = null;
        try {
            String filename = UUID.randomUUID().toString();
            byte[] bytes = file.getBytes();
            String fileOriginaName = file.getOriginalFilename();

            long fileSize = file.getSize();
            //Si se daña es aqui
            long maxFileSize = 9 * 1024 * 1024;
            if (fileSize > maxFileSize){
                System.out.println("El archivo debe ser menor o igual a 9MB");
                return documento;
            }
            if (!fileOriginaName.endsWith(".pdf")){
                System.out.println("Solo PDF");
                return documento;
            }
            String fileExtension = fileOriginaName.substring(fileOriginaName.lastIndexOf("."));
            String newFileName = filename + fileExtension;

            String rutaCarpeta = "pryEstudiante/src/main/resources/documentos/" + identificadorRuta;
            String rutaArchivo = rutaCarpeta + "/" + newFileName;
            File folder = new File(rutaCarpeta);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            Path path = Paths.get(rutaArchivo);
            Files.write(path,bytes);

            documento = new DocumentoDTO(file.getName(),rutaArchivo, EstadoDocumento.EN_PROCESO);
            System.out.println("Archivo subido exitosamente");
            return documento;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public ResponseEntity<String> estadoDocumento (Long id, EstadoDocumento estado){
        Optional<Aspirante> aspiranteOptional = aspRepository.findById(id);
        if (!aspiranteOptional.isPresent())
        {
            return ResponseEntity.ok("No existe un aspirante con ese id" + aspiranteOptional.get().getAspi_id());
        }
        Aspirante aspirante = aspiranteOptional.get();
        aspirante.getDocumentos().size();
        if (!aspirante.getDocumentos().isEmpty()){
            for(int i = 0; i < aspirante.getDocumentos().size(); i++){
                aspirante.getDocumentos().get(i).setEstado(estado);
                docRepository.save(aspirante.getDocumentos().get(i));
            }
            if (estado == EstadoDocumento.RECHAZADO){
                String asunto = "\uD83D\uDCDD Solicitud de Información Adicional para Completar Documentación \uD83D\uDCC4";
                String plantillaMensaje = "mensajeDocRechazado";
                HashMap<String,String> info = new HashMap<>();
                info.put("nombre", aspirante.getNombre());
                info.put("apellido", aspirante.getApellido());
                EmailDTO email = new EmailDTO(aspirante.getCorreo(), asunto, plantillaMensaje);
                email.setInfoMensaje(info);
                try {
                    emailService.sendMail(email);
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            }
            return ResponseEntity.ok("El estado se cambio exitosamente");
        }

        return ResponseEntity.ok("No hay documentos asociados para el id " + aspiranteOptional.get().getAspi_id());
    }
    public String subirArchivos(MultipartFile file, MultipartFile cedula, String identificadorRuta) throws Exception {
        try {
            String filename = UUID.randomUUID().toString();
            byte[] bytes = file.getBytes();
            String fileOriginaName = file.getOriginalFilename();

            long fileSize = file.getSize();
            //Si se daña es aqui
            long maxFileSize = 9 * 1024 * 1024;
            if (fileSize > maxFileSize){
                return "El archivo debe ser menor o igual a 9MB";
            }
            if (!fileOriginaName.endsWith(".pdf")){
                return "Solo PDF";
            }
            String fileExtension = fileOriginaName.substring(fileOriginaName.lastIndexOf("."));
            String newFileName = filename + fileExtension;

            File folder = new File("pryEstudiante/src/main/resources/documentos/" + identificadorRuta);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            Path path = Paths.get("pryEstudiante/src/main/resources/documentos/" + identificadorRuta + "/" + newFileName);
            Files.write(path,bytes);
            return "Archivo subido exitosamente";

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<Documento> listarDocumento(){
        List<Documento> resultado = StreamSupport
                .stream(this.docRepository.findAll().spliterator(),false)
                .toList();
        return resultado;
    }
}
