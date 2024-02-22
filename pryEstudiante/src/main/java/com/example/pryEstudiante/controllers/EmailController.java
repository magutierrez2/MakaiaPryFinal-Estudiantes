package com.example.pryEstudiante.controllers;

import com.example.pryEstudiante.dtos.EmailDTO;
import com.example.pryEstudiante.services.IEmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {
    @Autowired
    IEmailService iEmailService;
    @PostMapping("/enviarEmail")
    public ResponseEntity<String> sendEmail(@RequestBody EmailDTO email) throws MessagingException {
        iEmailService.sendMail(email);
        return new ResponseEntity<>("Correo " + "enviado exitosamente", HttpStatus.OK);
    }


}
