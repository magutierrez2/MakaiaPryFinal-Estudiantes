package com.example.pryEstudiante.services;
import com.example.pryEstudiante.dtos.AspiranteDTO;
import com.example.pryEstudiante.dtos.DocumentoDTO;
import com.example.pryEstudiante.dtos.EmailDTO;
import com.example.pryEstudiante.entities.Aspirante;
import com.example.pryEstudiante.entities.Documento;
import com.example.pryEstudiante.repositories.AspiranteRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class AspiranteService {

    AspiranteRepository aspRepository;
    IEmailService emailService;
    DocumentoService docService;
    @Autowired
    public AspiranteService(AspiranteRepository aspRepository, IEmailService emailService, DocumentoService docService){

        this.aspRepository = aspRepository;
        this.emailService = emailService;
        this.docService = docService;
    }

    public ResponseEntity<String> crearAspirante(AspiranteDTO dto){
        Optional<Aspirante> aspiranteOptional = aspRepository.findByCorreo(dto.getCorreo());
        if (aspiranteOptional.isPresent()){
            return ResponseEntity.ok("Aspirante ya existe");
        }
        if (dto.getCorreo() != null){
            Aspirante aspirante = new Aspirante(dto.getCedula(), dto.getNombre(), dto.getApellido(), dto.getCorreo(), dto.getDireccion(), dto.getTelefono());
            aspirante = this.aspRepository.save(aspirante);
            String asunto = "✍\uD83C\uDFFB ¡Estás a un paso de empezar tu entrenamiento! \uD83D\uDCAA\uD83C\uDFFB";
            String plantillaMensaje = "mensajeBienvenida";
            String ruta = "pryEstudiante/src/main/resources/archivo/ACTA.pdf";
            HashMap<String,String> info = new HashMap<>();
            info.put("nombre", aspirante.getNombre());
            info.put("apellido", aspirante.getApellido());
            EmailDTO email = new EmailDTO(dto.getCorreo(), asunto, plantillaMensaje,ruta );
            email.setInfoMensaje(info);
            try {
                emailService.sendMail(email);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
            return ResponseEntity.ok("Aspirante creado exitosamente");
        }
        return ResponseEntity.ok("No se pudo crear el Aspirante");
    }
    public ResponseEntity<String> subirDocumentacion(MultipartFile file, MultipartFile fileCedula, String cedula) throws Exception {
        Optional<Aspirante> aspiranteOptional = aspRepository.findByCedula(cedula);
        if (!aspiranteOptional.isPresent()){
            return ResponseEntity.ok("No existe Aspirante");
        }
        //Donde se van a guardar los archivos de un aspirante especifico
        String identificadorRuta = aspiranteOptional.get().getNombre()+"_"+cedula;

        //Guardamos los archivos en la carpeta especificada
        DocumentoDTO doc_acta = docService.guardarArchivoLocal(file,identificadorRuta);
        DocumentoDTO doc_cedula = docService.guardarArchivoLocal(fileCedula,identificadorRuta);

        if (doc_acta == null){
            return ResponseEntity.ok("Problema documento acta");
        }

        if (doc_cedula == null){
            return ResponseEntity.ok("Problema documento cedula");
        }

        AspiranteDTO aspiranteDTO = new AspiranteDTO(aspiranteOptional.get().getCedula(),aspiranteOptional.get().getNombre(),
                                        aspiranteOptional.get().getApellido(), aspiranteOptional.get().getCorreo(),
                                        aspiranteOptional.get().getDireccion(),aspiranteOptional.get().getTelefono());
        aspiranteDTO.setAspi_id(aspiranteOptional.get().getAspi_id());
        doc_acta.setObjAspirante(aspiranteDTO);
        doc_cedula.setObjAspirante(aspiranteDTO);

        Documento actaOpcional = docService.crearDocumento(doc_acta);
        Documento cedulaOpcional = docService.crearDocumento(doc_cedula);

        return ResponseEntity.ok("Se guardaron los archivos correctamente del aspirante");
    }
    public List<Aspirante> listarAspirante(){
        List<Aspirante> resultado = StreamSupport
                .stream(this.aspRepository.findAll().spliterator(),false)
                .toList();
        return resultado;
    }


}
