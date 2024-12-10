package org.ecopaula.station2.rabbitMQ;

import entity.PartType;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PartTypeConsumer {
    private List<PartType> partTypes;


}
