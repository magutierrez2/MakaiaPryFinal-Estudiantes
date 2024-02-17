package com.example.pryEstudiante.controllers;

import com.example.pryEstudiante.dtos.EmailDTO;
import com.example.pryEstudiante.services.IEmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {
    @Autowired
    IEmailService iEmailService;
    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailDTO email) throws MessagingException {
        iEmailService.sendMail(email);
        return new ResponseEntity<>("Correo " + "enviado exitosamente", HttpStatus.OK);
    }

}
