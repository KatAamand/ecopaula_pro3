package org.ecopaula.server.rabbitMQ;

import entity.PartType;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PartTypeProducer {
    private final RabbitTemplate rabbitTemplate;

    public PartTypeProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendPartTypes(List<PartType> partTypeList) {
        rabbitTemplate.convertAndSend("partTypeQueue", partTypeList);
    }
}
