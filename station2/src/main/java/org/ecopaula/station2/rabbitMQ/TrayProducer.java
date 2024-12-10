package org.ecopaula.station2.rabbitMQ;

import entity.Tray;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rabbitMQ.RabbitMQConstants;

@Service
public class TrayProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;


}
