package com.example.pryEstudiante.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @RabbitListener (queues = {"aspirante_admitido"})
    public void receiveEstudianteAdmitido(String process){
        System.out.println("un aspirante fue admitido");
    }
}
