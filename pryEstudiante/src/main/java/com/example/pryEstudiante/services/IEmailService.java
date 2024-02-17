package com.example.pryEstudiante.services;

import com.example.pryEstudiante.dtos.EmailDTO;
import jakarta.mail.MessagingException;

public interface IEmailService {
    public void sendMail(EmailDTO email) throws MessagingException;
}
