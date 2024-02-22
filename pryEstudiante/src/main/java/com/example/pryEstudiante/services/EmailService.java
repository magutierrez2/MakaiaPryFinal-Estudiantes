package com.example.pryEstudiante.services;

import com.example.pryEstudiante.dtos.EmailDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;


@Service
public class EmailService implements IEmailService{
    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    public EmailService(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }
    @Override
    public void sendMail(EmailDTO email)  {
        try {

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(email.getDestinatario());
            helper.setSubject(email.getAsunto());

            Context context = new Context();
            for (String clave:email.getInfoMensaje().keySet()){
                context.setVariable(clave, email.getInfoMensaje().get(clave));
            }
            String contentHTML = templateEngine.process(email.getPlantillaMensaje(),
                    context);
            helper.setText(contentHTML, true);
            if (email.getRutaArchivo() != null){
                File file = new File(email.getRutaArchivo());
                helper.addAttachment(file.getName(), file);
            }
            javaMailSender.send(message);
        }catch (Exception e){
            throw new RuntimeException("Error "+
                    "al enviar el correo" + e.getMessage(),e);
        }
    }
}
