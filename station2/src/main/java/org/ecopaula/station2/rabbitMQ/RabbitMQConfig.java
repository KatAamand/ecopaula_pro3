package org.ecopaula.station2.rabbitMQ;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rabbitMQ.RabbitMQConstants;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue station2Queue() {
        return new Queue(RabbitMQConstants.DISSECTION_QUEUE);
    }

    @Bean
    DirectExchange station2Exchange() {return new DirectExchange(RabbitMQConstants.STATIONS_EXCHANGE);}

    @Bean
    public Binding station1Binding(Queue station2Queue, DirectExchange stationsExchange) {
        return BindingBuilder.bind(station2Queue).to(stationsExchange).with("station2");
    }

    @Bean public FanoutExchange serverExchange() {
        return new FanoutExchange(RabbitMQConstants.SERVER_EXCHANGE);
    }

    @Bean
    Binding serverBinding(Queue station1Queue, FanoutExchange serverExchange) {
        return BindingBuilder.bind(station1Queue).to(serverExchange);
    }
}
