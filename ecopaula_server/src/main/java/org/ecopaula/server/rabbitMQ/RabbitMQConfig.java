package org.ecopaula.server.rabbitMQ;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static rabbitMQ.RabbitMQConstants.REGISTRATION_QUEUE;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue registrationQueue() {return new Queue(REGISTRATION_QUEUE, true);}
    @Bean
    public Queue partTypeQueue() {
        return new Queue("partTypeQueue", false);
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
