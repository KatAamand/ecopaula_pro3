package org.ecopaula.station1_registration.rabbitMQ;

import dto.AnimalDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Station1TestConfig {

    private final Station1Producer producer;

    public Station1TestConfig(Station1Producer producer) {
        this.producer = producer;
    }

    @Bean
    public CommandLineRunner sendTestAnimal() {
        return args -> {
            AnimalDTO animal = new AnimalDTO();
            producer.sendToServer(animal);
        };
    }
}
