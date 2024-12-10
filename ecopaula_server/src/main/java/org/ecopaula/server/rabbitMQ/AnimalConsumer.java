package org.ecopaula.server.rabbitMQ;

import dto.AnimalDTO;
import org.ecopaula.server.service.AnimalService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static rabbitMQ.RabbitMQConstants.REGISTRATION_QUEUE;

@Component
public class AnimalConsumer {
    private RabbitTemplate rabbitTemplate;

    private final AnimalService animalService;

    public AnimalConsumer(AnimalService animalService, RabbitTemplate rabbitTemplate) {
        this.animalService = animalService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = REGISTRATION_QUEUE)
    public void recieveAnimal(AnimalDTO animal) {
        animalService.createAnimal(animal);
        System.out.println("Recieved: " + animal);
    }
}
