package com.example.pryEstudiante.services;

import com.example.pryEstudiante.dtos.EmailDTO;
import jakarta.mail.MessagingException;
import org.springframework.web.multipart.MultipartFile;

public interface IEmailService {
    void sendMail(EmailDTO email) throws MessagingException;

}
