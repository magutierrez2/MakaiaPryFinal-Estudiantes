package com.example.pryEstudiante.publisher;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class Publisher {
   @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;
    public void  send (String id){
        this.rabbitTemplate.convertAndSend("estudiante_creado",id);
   }
}
