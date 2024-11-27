package org.ecopaula.station1_registration.rabbitMQ;

import dto.AnimalDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rabbitMQ.RabbitMQConstants;

@Service
public class Station1Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendToStation2(AnimalDTO animal) {
        rabbitTemplate.convertAndSend(RabbitMQConstants.STATIONS_EXCHANGE, "station2", animal);
        System.out.println("Message sent to station 2: " + animal);
    }

    public void sendToServer(AnimalDTO animal) {
        rabbitTemplate.convertAndSend(RabbitMQConstants.SERVER_EXCHANGE, "", animal);
        System.out.println("Message sent to server: " + animal);
    }
}
