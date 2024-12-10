package org.ecopaula.station1_registration.rabbitMQ;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rabbitMQ.RabbitMQConstants;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue station1Queue() {
        return new Queue(RabbitMQConstants.REGISTRATION_QUEUE, true);
    }

    @Bean
    public DirectExchange stationsExchange() {
        return new DirectExchange(RabbitMQConstants.STATIONS_EXCHANGE);
    }

    @Bean
    public Binding station1Binding(Queue station1Queue, DirectExchange stationsExchange) {
        return BindingBuilder.bind(station1Queue).to(stationsExchange).with("station1");
    }

    @Bean public FanoutExchange serverExchange() {
        return new FanoutExchange(RabbitMQConstants.SERVER_EXCHANGE);
    }

    @Bean
    Binding serverBinding(Queue station1Queue, FanoutExchange serverExchange) {
        return BindingBuilder.bind(station1Queue).to(serverExchange);
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
